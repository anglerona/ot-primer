package com.otprimer.backendserver.Comment;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="CommentModel", schema = "public" )
public class CommentModel {
    private @Id
    @GeneratedValue
    Integer id;

    private String comment;
    private Integer user_id;
    private Integer review_id;

    public CommentModel(){}

    CommentModel(String comment, Integer user_id, Integer review_id){
        this.comment = comment;
        this.user_id = user_id;
        this.review_id = review_id;
    }

}
