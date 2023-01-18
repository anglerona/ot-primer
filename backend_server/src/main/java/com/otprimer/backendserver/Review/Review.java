package com.otprimer.backendserver.Review;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.otprimer.backendserver.User.User;
import com.otprimer.backendserver.Movie.Movie;
import com.otprimer.backendserver.Comment.Comment;
import com.otprimer.backendserver.Vote.Vote;

@Entity
@Table(name="Review", schema = "public" )
public class Review {
    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    //ID , UserID, MovieID, Comment, Vote

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value="user")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
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


}