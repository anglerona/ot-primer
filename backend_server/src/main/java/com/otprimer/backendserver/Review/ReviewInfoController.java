package com.otprimer.backendserver.Review;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController // This allows for automatic response body
@RequestMapping(path="/")
public class ReviewInfoController {
    @Autowired

    private final ReviewInfoRepository reviewInfoRepository;


    public ReviewInfoController(final ReviewInfoRepository reviewInfoRepository){
        this.reviewInfoRepository = reviewInfoRepository;
    }



    @GetMapping(path="/getReviewInfo")
    public @ResponseBody Iterable<ReviewInfo> getReviewInfo() {
        // This returns a JSON or XML with the users
        return this.reviewInfoRepository.findAll();
    }



}