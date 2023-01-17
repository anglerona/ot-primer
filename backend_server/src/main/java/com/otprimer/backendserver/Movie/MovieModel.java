package com.otprimer.backendserver.Movie;


import com.otprimer.backendserver.Review.ReviewInfo;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="MovieModel", schema = "public" )
public class MovieModel {
    private @Id
    @GeneratedValue
    Integer id;



    @OneToMany(mappedBy = "movie")
    private Set<ReviewInfo> review;


    public MovieModel(){}

    MovieModel(Set<ReviewInfo> review){
        this.review = review;
    }

    public Set<ReviewInfo> getReview(){
        return this.review;
    }
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setReviewID(Set<ReviewInfo> review){
        this.review= review;
    }

}
