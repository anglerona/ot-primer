package com.otprimer.backendserver.Movie;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="MovieModel", schema = "public" )
public class MovieModel {
    private @Id
    @GeneratedValue
    Integer id;

    //foreign key
    private Integer review_id;


}
