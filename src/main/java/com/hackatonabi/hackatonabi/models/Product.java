package com.hackatonabi.hackatonabi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String productName;
    private String imageUrl;
    private Double consumptionTemperature;
    private String season;

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getConsumptionTemperature() {
        return consumptionTemperature;
    }

    public void setConsumptionTemperature(Double consumptionTemperature) {
        this.consumptionTemperature = consumptionTemperature;
    }
}
