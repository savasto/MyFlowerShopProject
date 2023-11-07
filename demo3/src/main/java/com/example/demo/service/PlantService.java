package com.example.demo.service;

import com.example.demo.model.Plant;
import com.example.demo.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;


@Service
    public class PlantService {
    @Autowired
    PlantRepository plantRepository;

    public Iterable<Plant> getAllPlants(){
        return plantRepository.findAll();
    }


    public Optional<Plant> findPlantById(String id) {
           Optional<Plant> plantFound=plantRepository.findById(id);
           return plantFound;}

public long quantityPlants(){
        return plantRepository.count();
}
public boolean deleteAllPlants(){
        plantRepository.deleteAll();
        long quantity=quantityPlants();
        boolean deletedPlants=true;
        if(quantity>0) deletedPlants=false;
        //else null;
    return deletedPlants;
}

    public Plant deleteById(String id) {

        Optional<Plant> plantFound= findPlantById(id);
        boolean plantRemoved = false;

        if (plantFound.isPresent()) {
plantRepository.deleteById(id);
           plantRemoved=true;
           return plantFound.get();
        } else return null;
    }
    public Plant createPlant(Plant plant) {
Plant plantSaved= plantRepository.save(plant);
       return plantSaved;
    }
    public Plant updatePlant(String id, Plant plant){
        Optional<Plant> plantFound=findPlantById(id);
        if(plantFound.isPresent()){
            Plant plantSaved=plantRepository.save(plant);
            return plantSaved;}
        else return null;
        }
    }


