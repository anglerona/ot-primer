package com.otprimer.backendserver.Review;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.otprimer.backendserver.User.User;
import com.otprimer.backendserver.Movie.Movie;
import com.otprimer.backendserver.Comment.Comment;
import com.otprimer.backendserver.Vote.Vote;

import java.time.LocalDateTime;

@Entity
@Table(name="Review", schema = "public" )
public class Review {
    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    //ID , UserID, MovieID, Comment, Vote

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value="user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    @JsonBackReference(value="movie")
    private Movie movie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    @JsonManagedReference
    private Comment comment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vote_id", referencedColumnName = "id")
    @JsonManagedReference
    private Vote vote;

    private String username;
    private String movieName;
    private LocalDateTime created;

    public Review(){}

    Review(User user, Movie movie, Comment comment, Vote vote){
        this.user= user;
        this.movie = movie;
        this.comment = comment;
        this.vote = vote;
    }

    public User getUser(){
        return this.user;
    }
    public Movie getMovie(){
        return this.movie;
    }
    public Comment getComment(){
        return this.comment;
    }
    public Vote getVote(){
        return this.vote;
    }
    public Integer getId(){
        return this.id;
    }

    public String getUsername() {
        return username;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setUserID(User user){
        this.user = user;
    }
    public void setMovieID(Movie movie){
        this.movie = movie;
    }
    public void setComment(Comment comment) {
        this.comment = comment;
    }
    public void setVote(Vote vote){
        this.vote = vote;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}