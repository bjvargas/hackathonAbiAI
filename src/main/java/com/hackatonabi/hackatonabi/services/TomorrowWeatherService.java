package com.hackatonabi.hackatonabi.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TomorrowWeatherService {
    private static final String TOMORROW_WEATHER_URL = "https://api.tomorrow.io/v4/timelines?location={latitude},{longitude}&fields=temperature&timesteps=1h&units=metric&apikey={apiKey}";
    private final WebClient webClient;

    public TomorrowWeatherService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getWeather(double latitude, double longitude, String apiKey) {
        return webClient.get()
                .uri(TOMORROW_WEATHER_URL, latitude, longitude, apiKey)
                .retrieve()
                .bodyToMono(String.class);
    }


    public Mono<String> getWeatherNow(double latitude, double longitude, String apiKey) {
        return webClient.get()
                .uri(TOMORROW_WEATHER_URL, latitude, longitude, apiKey)
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> {
                    try {
                        JsonNode root = new ObjectMapper().readTree(response);

                        JsonNode temperatureNode = root.path("data").path("timelines").get(0).path("intervals").get(0).path("values").path("temperature");

                        return String.valueOf(temperatureNode.asDouble());
                    } catch (Exception e) {
                        throw new RuntimeException("Erro ao extrair a temperatura da resposta da API", e);
                    }
                });
    }
}