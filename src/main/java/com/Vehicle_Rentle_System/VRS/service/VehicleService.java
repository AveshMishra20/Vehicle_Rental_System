package com.Vehicle_Rentle_System.VRS.service;

import com.Vehicle_Rentle_System.VRS.entity.Vehicle;
import com.Vehicle_Rentle_System.VRS.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle addVehicle(Vehicle vehicle){
       return vehicleRepository.save(vehicle);
    }


}
