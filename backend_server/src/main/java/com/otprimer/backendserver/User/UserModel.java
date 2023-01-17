package com.otprimer.backendserver.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="UserModel", schema = "public" )
public class UserModel {
    private @Id
    @GeneratedValue
    Integer id;

    private String user_name;

    public UserModel(){
    }

    UserModel(String user_name){
        this.user_name = user_name;
    }

    public String getUserName(){return this.user_name;}
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setUserName(String user_name){this.user_name = user_name;}
}
