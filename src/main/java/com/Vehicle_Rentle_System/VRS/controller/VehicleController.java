package com.Vehicle_Rentle_System.VRS.controller;

import com.Vehicle_Rentle_System.VRS.entity.Vehicle;
import com.Vehicle_Rentle_System.VRS.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping

    public ResponseEntity<String> getVehicleById(@PathVariable("Id") Long Id){

        return null;

    }
     @PostMapping("/addVehicle")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle){
         vehicleService.addVehicle(vehicle);

        return new ResponseEntity<>("Vehicle added with vehicle ID : "+ vehicle.getId(), HttpStatus.CREATED);
    }
}
