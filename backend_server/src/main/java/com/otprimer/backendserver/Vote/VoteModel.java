package com.otprimer.backendserver.Vote;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.otprimer.backendserver.Review.ReviewInfo;
import com.otprimer.backendserver.User.UserModel;

import javax.persistence.*;


@Entity
@Table(name="VoteModel", schema = "public" )
public class VoteModel {
    private @Id
    @GeneratedValue
    Integer id;

    private Integer like_dislike;

//    @OneToOne(mappedBy = "vote")
//    private UserModel user;

    @OneToOne(mappedBy = "vote")
    @JsonBackReference
    private ReviewInfo review;

    public VoteModel(){}
    VoteModel(Integer like_dislike, ReviewInfo review){
        this.like_dislike = like_dislike;
        //this.user= user;
        this.review = review;
    }

//    public UserModel getUserID(){return this.user;}
    public Integer getId(){
        return this.id;
    }
    public ReviewInfo getReviewID(){return this.review; }
    public Integer getLikeDislike(){return this.like_dislike;}

    public void setId(Integer id){
        this.id = id;
    }
//    public void setUserID(UserModel user_id){this.user = user;}
    public void setLikeDislike(Integer like_dislike){this.like_dislike = like_dislike;}
    public void setReview(ReviewInfo review){this.review = review;}

}
