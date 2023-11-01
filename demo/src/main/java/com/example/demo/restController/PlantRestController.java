package com.example.demo.restController;


import com.example.demo.model.Plant;
//import com.example.demo.service.ActivityLogService;
import com.example.demo.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/plants")
public class PlantRestController {

    @Autowired
    PlantService plantService;

   /* @Autowired
    ActivityLogService activityLogService;*/

    @GetMapping("/getAllPlants")
    public ArrayList<Plant> allPlants(Model container) {
        ArrayList<Plant> plantsFromService = plantService.getAllPlants();
        return plantService.getAllPlants();
    }

    @GetMapping("/getPlantById/{id}")
    public Plant getPlantById(@PathVariable String id){
        Plant plant=null;
        plant=plantService.findPlantById(id);
        return plant;
    }
    @DeleteMapping("/deleteAllPlants")
    public void deleteAllPlants()
    {
        plantService.deleteAllPlants();
    }

    /*@DeleteMapping("/deletePlantById/{id}"){
        public String deletePlantById(@PathVariable String id){
            return plantService.deleteById(String id);

        }
    }
    @PostMapping ("/createPlant}"){
    public void createPlant
    return }

    @PostMapping("/updatePlantById/{id}"){
        public Plant updatePlantById

    }*/


}