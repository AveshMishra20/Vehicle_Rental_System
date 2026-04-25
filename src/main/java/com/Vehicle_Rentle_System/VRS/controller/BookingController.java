package com.Vehicle_Rentle_System.VRS.controller;

import com.Vehicle_Rentle_System.VRS.dto.BookingRequest;
import com.Vehicle_Rentle_System.VRS.entity.Booking;
import com.Vehicle_Rentle_System.VRS.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    BookingServiceImpl bookingService;

    @PostMapping
    public ResponseEntity<String> book(@RequestBody BookingRequest request) {

        try {
            bookingService.book(
                    request.getUserId(),
                    request.getVehicleId(),
                    request.getStartDate(),
                    request.getEndDate()
            );

            return new ResponseEntity<>("You have Book the Car Succesfully with CarId " + request.getVehicleId(), HttpStatus.CREATED);
        }
        catch (RuntimeException exception){

            return new ResponseEntity<>("This vehicle is already booked " + request.getVehicleId(), HttpStatus.BAD_REQUEST);
        }
    }
}
