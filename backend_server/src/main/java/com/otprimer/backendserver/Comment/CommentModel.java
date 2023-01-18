package com.otprimer.backendserver.Comment;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.otprimer.backendserver.Review.ReviewInfo;
import com.otprimer.backendserver.User.UserModel;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;


@Entity
@Table(name="CommentModel", schema = "public" )
public class CommentModel {
    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    private String body;

//    @OneToOne0(mappedBy = "comment")
//    private UserModel user;

    @OneToOne(mappedBy = "comment")
    @JsonBackReference
    private ReviewInfo review;

    public CommentModel(){}

    CommentModel(String body, ReviewInfo review){
        this.body = body;
//        this.user = user;
        this.review = review;
    }

//    public UserModel getUserID(){
//        return this.user;
//    }
    public ReviewInfo getReview(){
        return this.review;
    }
    public String getBody(){
        return this.body;
    }
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }
//    public void setUserID(UserModel user){
//        this.user = user;
//    }
    public void setReview(ReviewInfo review){
        this.review = review;
    }
    public void setComment(String body){
        this.body = body;
    }



}
