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
    private Integer user_id;
    private Integer movie_id;
    private Integer comment_id;
    private Integer vote_id;



    public ReviewInfo(){}

    ReviewInfo(Integer user_id, Integer movie_id, Integer comment_id, Integer vote_id){
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.comment_id = comment_id;
        this.vote_id = vote_id;
    }

    public Integer getUserID(){
        return this.user_id;
    }
    public Integer getMovieID(){
        return this.movie_id;
    }
    public Integer getCommentID(){
        return this.comment_id;
    }
    public Integer getVoteID(){
        return this.vote_id;
    }
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setUserID(Integer userID){
        this.user_id = user_id;
    }
    public void setMovieID(Integer movieID){
        this.movie_id = movie_id;
    }
    public void setComment(String commentID) {
        this.comment_id = comment_id;
    }
    public void setVote(Integer voteID){
        this.vote_id = vote_id;
    }


}