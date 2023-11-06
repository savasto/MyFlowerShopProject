package com.example.demo.restController;

import com.example.demo.model.Bouquet;
import com.example.demo.model.Plant;
import com.example.demo.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class BouquetRestController {

   /* @RestController
    @RequestMapping("api/v1/plants/bouquet")
    public class BouquetRestController {

        @Autowired
        BouquetService bouquetService;

        @GetMapping("/getAllBouquets")
        public ArrayList<Bouquet> allBouquets(Model container) {
            ArrayList<Bouquet> bouquetsFromService = bouquetService.getAllBouquets();
            return bouquetService.getAllBouquets();
        }

        @GetMapping("/getBouquetById/{id}")
        public Bouquet getBouquetById(@PathVariable String id){
            Bouquet bouquet=null;
            bouquet=bouquetService.findBouquetById(id);
            return bouquet;
        }
        @DeleteMapping("/deleteAllBouquets")
        public void deleteAllBouquets()
        {
            bouquetService.deleteAllBouquets();
        }

        @DeleteMapping("/deleteBouquetById/{id}"){
            public String deleteBouquetById(@PathVariable String id){
                return bouquetService.deleteBouquetById(String id);

            }
        }
        @PostMapping ("/createPlant}"){
            public void createPlant
            return }

        @PostMapping("/updatePlantById/{id}"){
            public Plant updatePlantById

        }*/

    }
