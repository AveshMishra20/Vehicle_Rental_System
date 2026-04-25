package com.Vehicle_Rentle_System.VRS.service;

import com.Vehicle_Rentle_System.VRS.entity.Booking;
import com.Vehicle_Rentle_System.VRS.entity.User;
import com.Vehicle_Rentle_System.VRS.entity.Vehicle;
import com.Vehicle_Rentle_System.VRS.repository.BookingRepository;
import com.Vehicle_Rentle_System.VRS.repository.UserRepository;
import com.Vehicle_Rentle_System.VRS.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingServiceImpl {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    UserRepository userRepository;

    public Booking book (Long userId, Long vehicleId, LocalDate startDate, LocalDate endDate){

        List<Booking> checkConflicts = bookingRepository.findConflicts(vehicleId,startDate,endDate);
        if(!checkConflicts.isEmpty()){
            throw  new RuntimeException();
        }
        Vehicle vehicle= vehicleRepository.findById(vehicleId).orElseThrow();
        User user= userRepository.findById(userId).orElseThrow();

        Long days= ChronoUnit.DAYS.between(startDate,endDate);
        double total= days*(vehicle.getPricePerDay());
         Booking booking= new Booking();
         booking.setUser(user);
         booking.setVehicle(vehicle);
         booking.setStartDate(startDate);
         booking.setEndDate(endDate);
         booking.setTotalPrice(total);
         booking.setStatus("Booked");

         return bookingRepository.save(booking);

    }

}
