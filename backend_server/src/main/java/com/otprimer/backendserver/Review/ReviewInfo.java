package com.otprimer.backendserver.Review;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="ReviewInfo", schema = "public" )
public class ReviewInfo {
    private @Id
    @GeneratedValue
    Integer id;
    //ID , UserID, MovieID, Comment, Vote
    private String userID;
    private Long movieID;
    private String comment;
    private Integer vote;



    public ReviewInfo(){}

    ReviewInfo(String userID, Long movieID, String comment, Integer vote){
        this.userID = userID;
        this.movieID = movieID;
        this.comment = comment;
        this.vote = vote;
    }

    public String getUserID(){
        return this.userID;
    }
    public Long getMovieID(){
        return this.movieID;
    }
    public String getComment(){
        return this.comment;
    }
    public Integer getVote(){
        return this.vote;
    }
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public void setMovieID(Long movieID){
        this.movieID = movieID;

    }
    public void setComment(String comment){
        this.comment = comment;

    }
    public void setVote(Integer vote){
        this.vote = vote;
    }


}