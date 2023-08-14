package com.hackatonabi.hackatonabi.services;

import com.hackatonabi.hackatonabi.dto.GoogleMapsGeocodingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GoogleMapsGeocodingService {
    private static final String GOOGLE_MAPS_GEOCODING_URL = "https://maps.googleapis.com/maps/api/geocode/json?address={address}&key={apiKey}";
    private final RestTemplate restTemplate;
    public GoogleMapsGeocodingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public GoogleMapsGeocodingResponse getGeocodingData(String address, String apiKey) {
        ResponseEntity<GoogleMapsGeocodingResponse> response = restTemplate.getForEntity(GOOGLE_MAPS_GEOCODING_URL, GoogleMapsGeocodingResponse.class, address, apiKey);
        return response.getBody();
    }
}