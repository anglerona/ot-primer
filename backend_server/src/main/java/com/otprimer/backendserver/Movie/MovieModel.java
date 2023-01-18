package com.otprimer.backendserver.Movie;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference(value="movie")
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
    public void setReview(Set<ReviewInfo> review){
        this.review= review;
    }

}
