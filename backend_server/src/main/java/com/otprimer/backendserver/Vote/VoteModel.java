package com.otprimer.backendserver.Vote;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="VoteModel", schema = "public" )
public class VoteModel {
    private @Id
    @GeneratedValue
    Integer id;

    private Integer like_dislike;
    private Integer user_id;
    private Integer review_id;

    public VoteModel(){}
    VoteModel(Integer like_dislike, Integer user_id, Integer review_id){
        this.like_dislike = like_dislike;
        this.user_id = user_id;
        this.review_id = review_id;
    }

    public Integer getUserID(){return this.user_id;}
    public Integer getId(){
        return this.id;
    }
    public Integer getReviewID(){return this.review_id; }
    public Integer getLikeDislike(){return this.like_dislike;}

    public void setId(Integer id){
        this.id = id;
    }
    public void setUserID(Integer user_id){this.user_id = user_id;}
    public void setLikeDislike(Integer like_dislike){this.like_dislike = like_dislike;}
    public void setReviewID(Integer review_id){this.review_id = review_id;}

}
