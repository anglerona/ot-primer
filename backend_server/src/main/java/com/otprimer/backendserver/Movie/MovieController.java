package com.otprimer.backendserver.Movie;

import com.otprimer.backendserver.Comment.Comment;
import com.otprimer.backendserver.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path="/movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public Iterable<Movie> findAllMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable(value = "id") Integer id) {
        Optional<Movie> movie = movieRepository.findById(id);

        if(movie.isPresent()) {
            return ResponseEntity.ok().body(movie.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Movie saveMovie(@Validated @RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PostMapping(path="/new")
    public Movie saveNewMovie(@Validated @RequestBody Movie movie) {
        Optional<Movie> newMovie = movieRepository.findById(movie.getId());

        if(newMovie.isPresent()) {
            return newMovie.get();
        }
        else{
            return movieRepository.save(movie);
        }
    }


}
