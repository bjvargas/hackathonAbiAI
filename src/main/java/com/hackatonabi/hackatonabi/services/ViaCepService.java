package com.hackatonabi.hackatonabi.services;

import com.hackatonabi.hackatonabi.dto.ViaCepResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    private final RestTemplate restTemplate;

    public ViaCepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ViaCepResponse getCepData(String cep) {
        ResponseEntity<ViaCepResponse> response = restTemplate.getForEntity(VIA_CEP_URL, ViaCepResponse.class, cep);
        return response.getBody();
    }
}