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
import java.util.Optional;

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
        Iterable<Plant> plantsFromService=plantService.getAllPlants();
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
        }}

    @GetMapping("/getPlantById/{id}")
    public ResponseEntity<Plant> getPlantById(HttpServletRequest request, @PathVariable  String  id){
        // call to service for find by id
        Optional<Plant> plant = plantService.findPlantById(id);

        ActivityLog activityLog = Utilities.createLog(request,"getPlantById",
                "plants", "processing", "api/v1/plants/getPlantById", "GET");

        HttpHeaders headers = Utilities.createHeader(activityLog);

        if (plant != null) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            return ResponseEntity.accepted().headers(headers).body(plant.get());
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(null);
        }
    }

    @DeleteMapping("/deleteAllPlants")
    public ResponseEntity deleteAllPlants (HttpServletRequest request){
        // query to delete all books
        long quantity = plantService.quantityPlants();
        boolean deleted = plantService.deleteAllPlants();


        ActivityLog activityLog = Utilities.createLog(request,"deleteAllPlants",
                "plants", "processing", "api/v1/plants/deleteAllPlants", "DELETE");

        HttpHeaders headers = Utilities.createHeader(activityLog);

        if (deleted) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            headers.add("qtyObjectsDeleted", String.valueOf(quantity));
            return ResponseEntity.accepted().headers(headers).body(null);
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(null);
        }
    }


    @DeleteMapping("/deletePlantById/{id}")
        public ResponseEntity<Plant> deletePlantById (HttpServletRequest request, @PathVariable String id){

            Plant plant = plantService.deleteById(id);
            ActivityLog activityLog = Utilities.createLog(request,"deletePlantById",
                    "plants", "processing", "api/v1/plants/deletePlantById", "DELETE");

            HttpHeaders headers = Utilities.createHeader(activityLog);

            if (plant != null) {
                activityLog.setStatus("success");
                activityLogService.addActivityLog(activityLog);
                headers.add("status", "success");
                return ResponseEntity.accepted().headers(headers).body(plant);
            } else {
                activityLog.setStatus("fail");
                activityLogService.addActivityLog(activityLog);
                headers.add("status", "fail");
                return ResponseEntity.internalServerError().headers(headers).body(null);
            }
        }


    @PostMapping(path = "/createPlant", consumes = "application/JSON")
    public ResponseEntity<Plant> addPlant(HttpServletRequest request, @RequestBody Plant plant) {
        //
        ActivityLog activityLog = Utilities.createLog(request,"createPlant",
                "plants", "fail", "api/v1/plants/createPlant", "POST");


        HttpHeaders headers = Utilities.createHeader(activityLog);

        Plant plantCreated = plantService.createPlant(plant);


        if (plantCreated != null) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            return ResponseEntity.accepted().headers(headers).body(plant);
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(null);
        }
    }
//CRUD update
    @PutMapping("/updatePlant/{id}")
    public ResponseEntity<Plant> updatePlant (HttpServletRequest request, @PathVariable String id,
                                              @RequestBody Plant plant){

        Plant plantToUpdate = plantService.updatePlant(id, plant);

        ActivityLog activityLog = Utilities.createLog(request,"updatePlant",
                "plants", "processing", "api/v1/plants/updatePlant", "PUT");

        HttpHeaders headers = Utilities.createHeader(activityLog);

        if (plantToUpdate != null) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            return ResponseEntity.accepted().headers(headers).body(plantToUpdate);
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(plantToUpdate);
        }
    }
}

