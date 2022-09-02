package com.example.restintro.controller;

import com.example.restintro.model.User;
import com.example.restintro.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
/*
    @PostMapping("/deleteUser")
    public RequestEntity<User> deleteUser(){

    }

    @PostMapping("/editUser")
    public RequestEntity<User> editUser(){

    }

*/
}
