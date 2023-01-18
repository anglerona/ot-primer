package com.otprimer.backendserver.Comment;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.otprimer.backendserver.Review.ReviewInfo;

import javax.persistence.*;


@Entity
@Table(name="CommentModel", schema = "public" )
public class CommentModel {
    private @Id
    String id;

    private String body;
    private String user_id;
    @OneToOne(mappedBy = "comment")
    @JsonBackReference
    private ReviewInfo review;


    public CommentModel(){}

    CommentModel(String id, String body, String user_id, ReviewInfo review){
        this.id = id;
        this.body = body;
        this.user_id = user_id;
        this.review = review;
    }


    public String getUserID(){
        return this.user_id;
    }
    public ReviewInfo getReview(){
        return this.review;
    }
    public String getBody(){
        return this.body;
    }
    public String getID(){
        return this.id;
    }

    public void setUserID(String user_id){
        this.user_id = user_id;
    }
    public void setReview(ReviewInfo review){
        this.review = review;
    }
    public void setBody(String body){
        this.body = body;
    }
    public void setID(String id) {
        this.id = id;
    }


}
