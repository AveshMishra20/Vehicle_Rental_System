package com.Vehicle_Rentle_System.VRS.repository;

import com.Vehicle_Rentle_System.VRS.entity.Booking;
import com.Vehicle_Rentle_System.VRS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {


}
