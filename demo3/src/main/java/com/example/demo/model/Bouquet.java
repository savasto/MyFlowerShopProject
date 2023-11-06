package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private String bouquetId;
    private String codeOfBouquet;

    public Bouquet(String bouquetId, String codeOfBouquet) {
        this.bouquetId = bouquetId;
        this.codeOfBouquet = codeOfBouquet;
    }

    public Bouquet() {
    }
    private List<Plant> plants = new ArrayList<>();

    public Plant addPlant(Plant plant)  {
        plant.setBouquet(this);
        this.plants.add(plant);
        return plant;
    }


    public String getBouquetId() {
        return bouquetId;
    }

    public void setBouquetId(String bouquetId) {
        this.bouquetId = bouquetId;
    }

    public String getCodeOfBouquet() {
        return codeOfBouquet;
    }

    public void setCodeOfBouquet(String codeOfBouquet) {
        this.codeOfBouquet = codeOfBouquet;
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "bouquetId='" + bouquetId + '\'' +
                ", codeOfBouquet='" + codeOfBouquet + '\'' +
                '}';
    }
}
