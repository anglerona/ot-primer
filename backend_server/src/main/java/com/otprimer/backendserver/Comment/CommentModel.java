package com.otprimer.backendserver.Comment;


import com.otprimer.backendserver.Review.ReviewInfo;
import com.otprimer.backendserver.User.UserModel;

import javax.persistence.*;


@Entity
@Table(name="CommentModel", schema = "public" )
public class CommentModel {
    private @Id
    @GeneratedValue
    Integer id;

    private String comment;

    @OneToOne(mappedBy = "comment")
    private UserModel user;
    @OneToOne(mappedBy = "comment")
    private ReviewInfo review;

    public CommentModel(){}

    CommentModel(String comment, UserModel user, ReviewInfo review){
        this.comment = comment;
        this.user = user;
        this.review = review;
    }

    public UserModel getUserID(){
        return this.user;
    }
    public ReviewInfo getReviewID(){
        return this.review;
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
    public void setUserID(UserModel user){
        this.user = user;
    }
    public void setReviewID(ReviewInfo review){
        this.review = review;
    }
    public void setComment(String comment){
        this.comment = comment;
    }



}
