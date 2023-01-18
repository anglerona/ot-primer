package com.otprimer.backendserver.Comment;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.otprimer.backendserver.Review.Review;

import javax.persistence.*;


@Entity
@Table(name="Comment", schema = "public" )
public class Comment {
    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    private String body;

//    @OneToOne0(mappedBy = "comment")
//    private UserModel user;

    @OneToOne(mappedBy = "comment")
    @JsonBackReference
    private Review review;

    public Comment(){}

    Comment(String body, Review review){
        this.body = body;
//        this.user = user;
        this.review = review;
    }

//    public UserModel getUserID(){
//        return this.user;
//    }
    public Review getReview(){
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
    public void setReview(Review review){
        this.review = review;
    }
    public void setComment(String body){
        this.body = body;
    }



}
