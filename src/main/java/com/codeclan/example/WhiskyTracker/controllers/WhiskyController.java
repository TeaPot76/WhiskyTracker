package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping
    public List<Whisky> getAllWhiskys(){
        return whiskyRepository.findAll();
    }

    @GetMapping(value = "/year/{year}")
    public List<Whisky> findWhiskyByYear(@PathVariable int year){
        return whiskyRepository.findWhiskyByYear(year);
    }


    @GetMapping(value = "/age/{age}/distilleries")
    public List<Distillery> getDistilleriesForWhiskiesAged(@PathVariable int age){
        return distilleryRepository.getDistilleriesForWhiskiesAged(age);
    }


    @GetMapping(value = "/region/{region}")
    public List<Whisky> getAllWhiskiesFromRegion(@PathVariable String region){
        return whiskyRepository.getAllWhiskiesFromRegion(region);
    }



}
