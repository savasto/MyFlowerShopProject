package com.example.demo.model;

import java.util.UUID;

public class Plant {
    private String id;
    private String plantName;
    private String plantColor;
    private String plantOrigin;

    private Bouquet bouquet;


    public Plant(String id, String plantName, String plantColor, String plantOrigin){
        this.id = UUID.randomUUID().toString();
        this.plantName=plantName;
        this.plantColor=plantColor;
        this.plantOrigin=plantOrigin;
    }

    public Plant(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantColor() {
        return plantColor;
    }

    public void setPlantColor(String plantColor) {
        this.plantColor = plantColor;
    }

    public String getPlantOrigin() {
        return plantOrigin;
    }

    public void setPlantOrigin(String plantOrigin) {
        this.plantOrigin = plantOrigin;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id='" + id + '\'' +
                ", plantName='" + plantName + '\'' +
                ", plantColor='" + plantColor + '\'' +
                ", plantOrigin='" + plantOrigin + '\'' +
                '}';
    }

    public void setBouquet(Bouquet bouquet) {
        this.bouquet=bouquet;
    }
}
