package com.otprimer.backendserver.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;

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


    @GetMapping(path="/getMovies")
    public @ResponseBody List<Object> getMovies(){
        String url = "https://api.themoviedb.org/3/trending/movie/day?api_key=781cd82e7790ae7403010d9f126bcc2c";
        //String url = "https://jsonplaceholder.typicode.com/users/";
        RestTemplate restTemplate = new RestTemplate();

//        Object[] movies = restTemplate.getForObject(url, Object[].class);
//        return Arrays.asList(movies);

       

    }
}