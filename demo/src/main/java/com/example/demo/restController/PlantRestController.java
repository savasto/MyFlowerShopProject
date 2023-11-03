package com.example.demo.restController;


import com.example.demo.model.ActivityLog;
import com.example.demo.model.Plant;
import com.example.demo.service.ActivityLogService;
import com.example.demo.service.ActivityLogService;
import com.example.demo.service.PlantService;
import com.example.demo.utilities.Utilities;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/plants")
public class PlantRestController {

    @Autowired
    PlantService plantService;

    @Autowired
    ActivityLogService activityLogService;

    @GetMapping("/getAllPlants")

    public ResponseEntity<Iterable<Plant>> getAllPlants(HttpServletRequest request) {

        // query to service to get all books
        ArrayList<Plant> plantsFromService = plantService.getAllPlants();
        // call Utilities to create a log
        ActivityLog activityLog = Utilities.createLog(request, "getAllPlants",
                "plants", "processing", "/api/v1/plants/getAllPlants", "GET");
        HttpHeaders headers = Utilities.createHeader(activityLog);
        //Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        //System.out.println("Lapsed time: " + ( timestamp2.getNanos() - timestamp.getNanos()));

        if (plantsFromService != null) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            return ResponseEntity.accepted().headers(headers).body(plantsFromService);
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(plantsFromService);
        }

    /*@GetMapping("/getPlantById/{id}")
    public Plant getPlantById(@PathVariable String id){
        Plant plant=null;
        plant=plantService.findPlantById(id);
        return plant;
    }
    @DeleteMapping("/deleteAllPlants")
    public void deleteAllPlants()
    {
        plantService.deleteAllPlants();
    }*/

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


    }}