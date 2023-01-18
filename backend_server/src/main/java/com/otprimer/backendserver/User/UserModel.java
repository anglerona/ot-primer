package com.otprimer.backendserver.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.otprimer.backendserver.Comment.CommentModel;
import com.otprimer.backendserver.Review.ReviewInfo;
import com.otprimer.backendserver.Vote.VoteModel;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="UserModel", schema = "public" )
public class UserModel {
    private @Id
    String id;

    private String user_name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value="user")
    private Set<ReviewInfo> review;


    public UserModel(){
    }

    UserModel(String user_name, Set<ReviewInfo> review){
        this.review = review;
        this.user_name = user_name;
    }

    public String getUserName(){return this.user_name;}
    public String getId(){
        return this.id;
    }
    public Set<ReviewInfo> getReview(){return this.review;}

    public void setId(String id){
        this.id = id;
    }
    public void setUserName(String user_name){this.user_name = user_name;}
    public void setReview(Set<ReviewInfo> review){this.review = review;}
}
