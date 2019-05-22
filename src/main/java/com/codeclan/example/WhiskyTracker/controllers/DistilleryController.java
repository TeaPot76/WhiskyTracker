package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;


    @GetMapping
    public List<Distillery> getAllDistilleries(){
        return distilleryRepository.findAll();
    }

    @GetMapping(value = "/region/{region}")
    public List<Distillery> findDistilleryByRegion(@PathVariable String region){
        return distilleryRepository.findDistilleryByRegion(region);

    }

    @GetMapping(value ="/region/{region}/whisky/{whisky_id}")
    public List<Distillery> findWhiskyFromDistilleryByRegion(@PathVariable("region") String region,
    @PathVariable("whisky_id") Long whisky_id){

        return distilleryRepository.findDistilleryByRegion(region);
    }


}
