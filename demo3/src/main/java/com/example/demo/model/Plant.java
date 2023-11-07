package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;
@Entity
@Data // generates getters, setters, equals, hashCode, and toString methods
@NoArgsConstructor // generates a no-args constructor
@AllArgsConstructor // generates a constructor with all arguments
@Table(name="PLANTS")
public class Plant {
    @Id
    private String id;
    private String plantName;
    private String plantColor;
    private String plantOrigin;
   //private Bouquet bouquet;
    }

   // public void setBouquet(Bouquet bouquet) {this.bouquet=bouquet;}

