package com.otprimer.backendserver.Vote;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.otprimer.backendserver.Review.Review;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;


@Entity
@CrossOrigin
@Table(name="Vote", schema = "public" )
public class Vote {
    private @Id
    @GeneratedValue
    Integer id;

    private Integer like_dislike;

//    @OneToOne(mappedBy = "vote")
//    private UserModel user;

    @OneToOne(mappedBy = "vote")
    @JsonBackReference
    private Review review;

    public Vote(){}
    Vote(Integer like_dislike, Review review){
        this.like_dislike = like_dislike;
        //this.user= user;
        this.review = review;
    }

//    public UserModel getUserID(){return this.user;}
    public Integer getId(){
        return this.id;
    }
    public Review getReview(){return this.review; }
    public Integer getLikeDislike(){return this.like_dislike;}

    public void setId(Integer id){
        this.id = id;
    }
//    public void setUserID(UserModel user_id){this.user = user;}
    public void setLikeDislike(Integer like_dislike){this.like_dislike = like_dislike;}
    public void setReview(Review review){this.review = review;}

}
