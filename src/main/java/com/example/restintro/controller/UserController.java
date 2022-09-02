package com.example.restintro.controller;

import com.example.restintro.model.User;
import com.example.restintro.service.UserService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Set<User>> index(){

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public User getUser(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/deleteUser/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
    throws ResourceNotFoundException{
    User user = userService.findById(userId).orElseThrow() -> new ResourceNotFoundException("user not found");

    userService.delete(user);
    }
/*
    @PostMapping("/editUser")
    public RequestEntity<User> editUser(){

    }

*/
}
