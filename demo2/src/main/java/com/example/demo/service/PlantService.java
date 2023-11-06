package com.example.demo.service;

import com.example.demo.model.Plant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;


@Service
    public class PlantService {
        static ArrayList<Plant> plants = new ArrayList<>();


        static{
           // String uniqueID = UUID.randomUUID().toString();
            plants.add(new Plant("rose","red","Holland"));
            plants.add(new Plant( "lily","rose","Holland"));
            plants.add(new Plant( "iris","violet","Holland"));
            plants.add(new Plant( "sunflower","yellow","Holland"));
            plants.add(new Plant( "rose","white","Holland"));
            plants.add(new Plant( "violet","violet","Germany"));
            plants.add(new Plant( "jasmine","white","Holland"));
            plants.add(new Plant( "lotus","rose","Holland"));
            plants.add(new Plant( "tulip","black","Germany"));
            plants.add(new Plant( "tulip","red","Holland"));

        }

        public ArrayList<Plant> getAllPlants() {
            return plants;
        }

        public Plant findPlantById(String id) {
            Plant plantFound = null;

            for (Plant plant : plants) {
                boolean checkPlant = plant.getId().equals(id);
                if (checkPlant) {
                    plantFound = plant;
                    break;
                }
            }
            return plantFound;
        }

        public void deleteAllPlants() {
            plants.clear();
        }

    public Plant deleteById(String id) {

        Plant plant = findPlantById(id);
        boolean plantRemoved = false;

        if (plant != null) {

            plantRemoved = plants.remove(plant);
            return plant;

        } else return null;
    }
    public Plant createPlant(Plant plant) {

        boolean plantAdded = plants.add(plant);

        if (plantAdded) return plant; else return null;
    }
    }

