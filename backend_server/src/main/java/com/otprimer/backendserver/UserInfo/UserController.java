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



    @GetMapping(path="/allUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return this.userRepository.findAll();
    }


    @GetMapping("/getMovies")
    public ResponseEntity<?> getMovies() {
        //Source: https://mercyjemosop.medium.com/consume-external-api-spring-boot-7e2c684e3d00
        try {
            String uri="https://api.themoviedb.org/3/trending/movie/day?api_key=781cd82e7790ae7403010d9f126bcc2c";
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}