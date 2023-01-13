package com.backend.backend_server.UserLogin;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="Username")
public class User {
    private @Id
    @GeneratedValue
    Long id;

    private String USERNAME;
    public User(){}

    User(String USERNAME){
        this.USERNAME = USERNAME;
    }

    public String get_USERNAME(){
        return this.USERNAME;
    }

    public void set_USERNAME(String USERNAME){
        this.USERNAME = USERNAME;
    }


}
