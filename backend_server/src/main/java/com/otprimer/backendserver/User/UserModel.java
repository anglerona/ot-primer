package com.otprimer.backendserver.User;

import com.otprimer.backendserver.Review.ReviewInfo;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="UserModel", schema = "public" )
public class UserModel {
    private @Id
    @GeneratedValue
    Integer id;

    private String user_name;

    @OneToMany(mappedBy = "user")
    private Set<ReviewInfo> review;


    public UserModel(){
    }

    UserModel(String user_name, Set<ReviewInfo> review){
        this.review = review;
        this.user_name = user_name;
    }

    public String getUserName(){return this.user_name;}
    public Integer getId(){
        return this.id;
    }
    public Set<ReviewInfo> getReview(){return this.review;}

    public void setId(Integer id){
        this.id = id;
    }
    public void setUserName(String user_name){this.user_name = user_name;}
    public void setReview(Set<ReviewInfo> review){this.review = review;}
}
