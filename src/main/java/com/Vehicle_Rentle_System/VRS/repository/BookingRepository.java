package com.Vehicle_Rentle_System.VRS.repository;

import com.Vehicle_Rentle_System.VRS.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    
    @Query("select b from Booking b where b.vehicle.id= :vehicleId"+ " And b.startDate<= :endDate And b.endDate>= :startDate")
    List<Booking> findConflicts(
            @Param("vehicleId") Long vehicleId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}