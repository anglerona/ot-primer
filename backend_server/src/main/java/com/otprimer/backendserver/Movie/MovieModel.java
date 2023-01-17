package com.otprimer.backendserver.Movie;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="MovieModel", schema = "public" )
public class MovieModel {
    private @Id
    @GeneratedValue
    Integer id;

    //foreign key
    private Integer review_id;

    public MovieModel(){}

    MovieModel(Integer review_id){
        this.review_id = review_id;
    }



    public Integer getReviewID(){
        return this.review_id;
    }
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setReviewID(Integer review_id){
        this.review_id= review_id;
    }



}
