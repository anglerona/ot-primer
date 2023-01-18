package com.otprimer.backendserver.Review;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController // This allows for automatic response body
@RequestMapping(path="/review")
public class ReviewInfoController {
    @Autowired

    private final ReviewInfoRepository reviewInfoRepository;


    public ReviewInfoController(final ReviewInfoRepository reviewInfoRepository){
        this.reviewInfoRepository = reviewInfoRepository;
    }



    @GetMapping
    public @ResponseBody Iterable<ReviewInfo> getReviewInfo() {
        // This returns a JSON or XML with the users
        return this.reviewInfoRepository.findAll();
    }

    @PostMapping
    public ReviewInfo saveReview(@Validated @RequestBody ReviewInfo reviewInfo){
        reviewInfo.getComment().setReview(reviewInfo);
        reviewInfo.getVote().setReview((reviewInfo));
        return reviewInfoRepository.save(reviewInfo);
    }
}