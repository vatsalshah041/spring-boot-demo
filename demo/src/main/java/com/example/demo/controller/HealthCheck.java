package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//make this healthcheck always whenevr building a app in spring boot

@RestController
public class HealthCheck {
    @GetMapping("/health-check")
    public String healthCheck(){
        return "Ok";
    }
}
