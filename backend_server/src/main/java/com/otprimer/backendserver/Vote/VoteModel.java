package com.otprimer.backendserver.Vote;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="VoteModel", schema = "public" )
public class VoteModel {
    private @Id
    @GeneratedValue
    Integer id;

    private Integer like_dislike;
    private Integer user_id;
    private Integer review_id;
}
