package com.otprimer.backendserver.TheMovieDb;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController // This allows for automatic response body
@RequestMapping(path="/")
public class MovieDbController{
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