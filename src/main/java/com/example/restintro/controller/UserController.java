package com.example.restintro.controller;

import com.example.restintro.model.User;
import com.example.restintro.service.UserService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


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
    public User getUser(@RequestParam(required = false) String username,@RequestParam(required = false) String password){
        return userService.save(new User(username, password));
    }

    @PostMapping("/deleteUser")
    public void deleteUser(@RequestParam Long id) {
        userService.deleteById(id);
    }


    @PostMapping("/editUser/{id}")
    public void editUser(@PathVariable long id,@RequestParam(required = false) String username ,@RequestParam(required = false) String password){


    }

}
