package com.Vehicle_Rentle_System.VRS.controller;


import com.Vehicle_Rentle_System.VRS.entity.User;
import com.Vehicle_Rentle_System.VRS.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;

@GetMapping("/user")
    public ResponseEntity<User> getUserById(@PathVariable("Id") Long userId){

        return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PostMapping("/adduser")
  public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("User added succesfully with userId :"+user.getId(),HttpStatus.CREATED);

  }
@GetMapping("getAllUsers")
  public ResponseEntity<List<User>> getAllUsers(){
        return  new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
  }

}
