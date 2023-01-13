package com.otprimer.backendserver.UserInfo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="Username", schema = "public" )
public class User {
    private @Id
    @GeneratedValue
    Integer id;

    private String USERID;
    public User(){}

    User(String USERID){
        this.USERID = USERID;
    }

    public String get_USERID(){
        return this.USERID;
    }

    public void set_USERID(String USERID){
        this.USERID = USERID;
    }

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }

}