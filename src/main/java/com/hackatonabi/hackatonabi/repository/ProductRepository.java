package com.hackatonabi.hackatonabi.repository;

import com.hackatonabi.hackatonabi.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByConsumptionTemperatureBetween(Double minTemp, Double maxTemp);
    List<Product> findBySeason(String season);

}
