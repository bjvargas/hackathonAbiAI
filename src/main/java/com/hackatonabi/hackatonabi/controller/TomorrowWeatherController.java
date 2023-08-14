package com.hackatonabi.hackatonabi.controller;

import com.hackatonabi.hackatonabi.dto.GoogleMapsGeocodingResponse;
import com.hackatonabi.hackatonabi.dto.ViaCepResponse;
import com.hackatonabi.hackatonabi.services.GoogleMapsGeocodingService;
import com.hackatonabi.hackatonabi.services.TomorrowWeatherService;
import com.hackatonabi.hackatonabi.services.ViaCepService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TomorrowWeatherController {

    private final ViaCepService viaCepService;
    private final TomorrowWeatherService tomorrowWeatherService;
    private final GoogleMapsGeocodingService googleMapsGeocodingService;

    @Value("${apiKeys.googleMaps}")
    private String googleMapsApiKey;
    @Value("${apiKeys.tomorrowWeather}")
    private String tomorrowWeatherApiKey;

    public TomorrowWeatherController(ViaCepService viaCepService, TomorrowWeatherService tomorrowWeatherService, GoogleMapsGeocodingService googleMapsGeocodingService) {
        this.viaCepService = viaCepService;
        this.tomorrowWeatherService = tomorrowWeatherService;
        this.googleMapsGeocodingService = googleMapsGeocodingService;
    }

    @GetMapping("/tomorrow-weather/{latitude}/{longitude}")
    public Mono<String> getWeatherByCoordinates(@PathVariable double latitude, @PathVariable double longitude) {
        return tomorrowWeatherService.getWeatherNow(latitude, longitude, tomorrowWeatherApiKey);
    }

    @GetMapping("/tomorrow-weather/cep/{cep}")
    public Mono<String> getWeatherByCep(@PathVariable String cep) {
        ViaCepResponse cepData = viaCepService.getCepData(cep);
        String address = cepData.getLogradouro() + ", " + cepData.getLocalidade() + ", " + cepData.getUf();
        GoogleMapsGeocodingResponse geocodingData = googleMapsGeocodingService.getGeocodingData(address, googleMapsApiKey);
        double latitude = geocodingData.getResults().get(0).getGeometry().getLocation().getLat();
        double longitude = geocodingData.getResults().get(0).getGeometry().getLocation().getLng();
        return getWeatherByCoordinates(latitude, longitude);
    }
}