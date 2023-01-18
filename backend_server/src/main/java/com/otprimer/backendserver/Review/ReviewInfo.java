package com.otprimer.backendserver.Review;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.otprimer.backendserver.Comment.CommentModel;

import javax.persistence.*;


@Entity
@Table(name="ReviewInfo", schema = "public" )
public class ReviewInfo {
    private @Id
    String id;
    //ID , UserID, MovieID, Comment, Vote
    private String user_id;
    private Integer movie_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    @JsonManagedReference
    private CommentModel comment;
    private Integer vote_id;



    public ReviewInfo(){}

    ReviewInfo(String id, String user_id, Integer movie_id, CommentModel comment, Integer vote_id){
        this.id = id;
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.comment = comment;
        this.vote_id = vote_id;
    }

    public String getUserID(){
        return this.user_id;
    }
    public Integer getMovieID(){
        return this.movie_id;
    }
    public CommentModel getComment(){
        return this.comment;
    }
    public Integer getVoteID(){
        return this.vote_id;
    }
    public String getID(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setUserID(String user_id) {
        this.user_id = user_id;
    }
    public void setMovieID(Integer movie_id){
        this.movie_id = movie_id;
    }
    public void setComment(CommentModel comment) {
        this.comment = comment;
    }
    public void setVoteID(Integer vote_id){
        this.vote_id = vote_id;
    }


}