package com.otprimer.backendserver.Review;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController // This allows for automatic response body
@CrossOrigin
@RequestMapping(path="/review")
public class ReviewController {
    @Autowired

    private final ReviewRepository reviewRepository;


    public ReviewController(final ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<Review> getReviews() {
        // This returns a JSON or XML with the users
        return reviewRepository.findAll();
    }

    @PostMapping
    public Review saveReview(@Validated @RequestBody Review review){
        review.getComment().setReview(review);
        review.setUsername(review.getUser().getId());
        review.setMovieName(review.getMovie().getName());
        review.getVote().setReview(review);
        return reviewRepository.save(review);
    }


}