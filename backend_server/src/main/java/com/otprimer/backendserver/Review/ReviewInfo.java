package com.otprimer.backendserver.Review;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.otprimer.backendserver.User.UserModel;
import com.otprimer.backendserver.Movie.MovieModel;
import com.otprimer.backendserver.Comment.CommentModel;
import com.otprimer.backendserver.Vote.VoteModel;
import org.apache.catalina.User;

@Entity
@Table(name="ReviewInfo", schema = "public" )
public class ReviewInfo {
    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    //ID , UserID, MovieID, Comment, Vote

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value="user")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    @JsonBackReference(value="movie")
    private MovieModel movie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    @JsonManagedReference
    private CommentModel comment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vote_id", referencedColumnName = "id")
    @JsonManagedReference
    private VoteModel vote;

    private String username;
    private String movieName;

    public ReviewInfo(){}

    ReviewInfo(UserModel user, MovieModel movie, CommentModel comment, VoteModel vote){
        this.user= user;
        this.movie = movie;
        this.comment = comment;
        this.vote = vote;
    }

    public UserModel getUser(){
        return this.user;
    }
    public MovieModel getMovie(){
        return this.movie;
    }
    public CommentModel getComment(){
        return this.comment;
    }
    public VoteModel getVote(){
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
    public void setUserID(UserModel user){
        this.user = user;
    }
    public void setMovieID(MovieModel movie){
        this.movie = movie;
    }
    public void setComment(CommentModel comment) {
        this.comment = comment;
    }
    public void setVote(VoteModel vote){
        this.vote = vote;
    }


}