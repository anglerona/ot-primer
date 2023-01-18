package com.otprimer.backendserver.User;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.otprimer.backendserver.Review.Review;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="User", schema = "public" )
public class User {
    private @Id
    @GeneratedValue
    Integer id;

    private String user_name;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value="user")
    private Set<Review> review;


    public User(){
    }

    User(String user_name, Set<Review> review){
        this.review = review;
        this.user_name = user_name;
    }

    public String getUserName(){return this.user_name;}
    public Integer getId(){
        return this.id;
    }
    public Set<Review> getReview(){return this.review;}

    public void setId(Integer id){
        this.id = id;
    }
    public void setUserName(String user_name){this.user_name = user_name;}
    public void setReview(Set<Review> review){this.review = review;}
}
