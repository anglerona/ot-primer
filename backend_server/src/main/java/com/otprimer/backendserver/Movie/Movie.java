package com.otprimer.backendserver.Movie;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.otprimer.backendserver.Review.Review;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="Movie", schema = "public" )
public class Movie {
    private @Id
    Integer id;



    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonManagedReference(value="movie")
    private Set<Review> review;

    private String name;


    public Movie(){}

    Movie(Set<Review> review){
        this.review = review;
    }

    public Set<Review> getReview(){
        return this.review;
    }
    public Integer getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setReview(Set<Review> review){
        this.review= review;
    }

}
