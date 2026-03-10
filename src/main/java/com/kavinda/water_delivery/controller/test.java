package com.kavinda.water_delivery.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test{

    @GetMapping("/ping")

    public String ping(){
        return "pongg fucking hell ";
    }
}
