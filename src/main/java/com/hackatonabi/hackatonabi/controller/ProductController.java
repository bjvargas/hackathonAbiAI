package com.hackatonabi.hackatonabi.controller;

import com.hackatonabi.hackatonabi.models.Product;
import com.hackatonabi.hackatonabi.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/suggestions")
    public List<Product> getSuggestedProducts(@RequestParam double currentTemperature) {
        return productService.getSuggestedProducts(currentTemperature);
    }

    @GetMapping("/products/season")
    public List<Product> getProductsBySeason(@RequestParam String season) {
        return productService.getProductsBySeason(season);
    }
}
