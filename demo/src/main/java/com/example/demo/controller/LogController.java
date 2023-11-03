
package com.example.demo.controller;


import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

    @Controller
    @RequestMapping("/activity")
    public class LogController {


        @Autowired
        ActivityLogService activityLogService;

        @RequestMapping("/logs")
        public String getAllUsers(Model model) {
            // fetch all users, add to model
            model.addAttribute("logs", activityLogService.getAllLogs());
            model.addAttribute("todayDate", new Date());
            model.addAttribute("totalLogs", "Total logs: " + activityLogService.getAllLogs().size());


            return "logs";
        }
    }

