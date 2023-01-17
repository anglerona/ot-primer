package com.otprimer.backendserver.Comment;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="CommentModel", schema = "public" )
public class CommentModel {
    private @Id
    @GeneratedValue
    Integer id;

    private String comment;
    private Integer user_id;
    private Integer review_id;

    public CommentModel(){}

    CommentModel(String comment, Integer user_id, Integer review_id){
        this.comment = comment;
        this.user_id = user_id;
        this.review_id = review_id;
    }

    public Integer getUserID(){
        return this.user_id;
    }
    public Integer getReviewID(){
        return this.review_id;
    }
    public String getComment(){
        return this.comment;
    }
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setUserID(Integer user_id){
        this.user_id = user_id;
    }
    public void setReviewID(Integer review_id){
        this.review_id = review_id;
    }
    public void setComment(String comment){
        this.comment = comment;
    }



}
