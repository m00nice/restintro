package com.example.restintro.controller;

import com.example.restintro.exception.ResourceNotFoundException;
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

    @PostMapping("/deleteUser/{id}")
    public Map<String,Boolean> deleteUser(@PathVariable long id)
    throws ResourceNotFoundException{
        userService.deleteById(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }


    @PutMapping("/editUser/{id}")
    public ResponseEntity<User> editUser(@PathVariable long id,@RequestParam(required = false) String username ,@RequestParam(required = false) String password)
    throws ResourceNotFoundException{
        User user = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("No user with this id "+id+" exists"));
        if(username == null && password != null){
            user.setPassword(password);
            userService.save(user);
        }
        if(username != null && password == null){
            user.setUsername(username);
            userService.save(user);
        }
        if(username != null && password != null){
            user.setUsername(username);
            user.setPassword(password);
            userService.save(user);
        }
        return ResponseEntity.ok(user);
    }

}
