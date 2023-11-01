package com.example.demo.controller;

import com.example.demo.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



    // manage request and response
    @Controller
    public class PlantController {

        // connect controller and service
        @Autowired
        PlantService plantService;
        // manages path books
        // gets the request, and then hte method starts
        // creates a Model container and uses @Autowired to connect with service
        // gets all books and then sends to html th

        @RequestMapping("/plants")
        public String AllPlants (Model plantsContainer){

            //plantService.deleteAllPlants();
            // inject plants -data- to template -html-th-
            plantsContainer.addAttribute("plantsToTH",  plantService.getAllPlants() );
//
            // return web render
            return "plants.html";
        }
    }
