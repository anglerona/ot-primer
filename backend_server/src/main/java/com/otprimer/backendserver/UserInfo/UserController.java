package com.otprimer.backendserver.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController // This allows for automatic response body
@RequestMapping(path="/")
public class UserController{
    @Autowired

    private final UserRepository userRepository;


    public UserController(final UserRepository userRepository){
        this.userRepository = userRepository;
    }



    @GetMapping(path="/getUserInfo")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return this.userRepository.findAll();
    }



}