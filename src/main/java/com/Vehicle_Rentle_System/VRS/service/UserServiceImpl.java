package com.Vehicle_Rentle_System.VRS.service;

import com.Vehicle_Rentle_System.VRS.entity.User;
import com.Vehicle_Rentle_System.VRS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        Optional<User> existingUser=userRepository.findById(user.getId());
        if(existingUser.isPresent()){
            throw new RuntimeException("User already Exist with userId : "+user.getId());

        }
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
       return userRepository.findAll();
    }
    public User getUserById(Long id){
        Optional<User> user= userRepository.findById(id);
        if(user.isPresent()){
            User u= new User();

            return u;
        }

        else
            throw  new RuntimeException("User does not exist with user id :" + id);
    }
}
