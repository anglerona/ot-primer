package com.otprimer.backendserver.Review;

import com.otprimer.backendserver.Movie.Movie;
import com.otprimer.backendserver.Movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController // This allows for automatic response body
@CrossOrigin
@RequestMapping(path="/review")
public class ReviewController {
    @Autowired

    private final ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;


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
        review.getVote().setReview(review);
        Integer vote = review.getVote().getLikeDislike();
        Movie movie = movieRepository.findById((review.getMovie().getId())).get();
        review.setMovieName(movie.getName());
        if(vote == 1){
            int likes = movie.getLikes();
            likes++;
            movie.setLikes(likes);
        }
        else if(vote == -1){
            int dislikes = movie.getDislikes();
            dislikes++;
            movie.setDislikes(dislikes);
        }
        review.setCreated(LocalDateTime.now());
        return reviewRepository.save(review);
    }


}