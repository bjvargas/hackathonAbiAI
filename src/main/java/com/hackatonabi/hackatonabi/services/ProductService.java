package com.hackatonabi.hackatonabi.services;

import com.hackatonabi.hackatonabi.models.Product;
import com.hackatonabi.hackatonabi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getSuggestedProducts(final Double currentTemperature) {
        Double minTemp = currentTemperature - 4;
        Double maxTemp = currentTemperature + 4;
        return productRepository.findByConsumptionTemperatureBetween(minTemp, maxTemp);
    }

    public List<Product> getProductsBySeason(String season) {
        return productRepository.findBySeason(season);
    }
}