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


}
