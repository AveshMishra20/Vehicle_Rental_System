package com.Vehicle_Rentle_System.VRS.repository;

import com.Vehicle_Rentle_System.VRS.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

}
