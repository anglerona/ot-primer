package com.otprimer.backendserver.Review;

import javax.persistence.*;
import com.otprimer.backendserver.User.UserModel;
import com.otprimer.backendserver.Movie.MovieModel;
import com.otprimer.backendserver.Comment.CommentModel;
import com.otprimer.backendserver.Vote.VoteModel;
import org.apache.catalina.User;

@Entity
@Table(name="ReviewInfo", schema = "public" )
public class ReviewInfo {
    private @Id
    @GeneratedValue
    Integer id;
    //ID , UserID, MovieID, Comment, Vote

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserModel user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private MovieModel movie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    private CommentModel comment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vote_id", referencedColumnName = "id")
    private VoteModel vote;


    public ReviewInfo(){}

    ReviewInfo(UserModel user, MovieModel movie, CommentModel comment, VoteModel vote){
        this.user= user;
        this.movie = movie;
        this.comment = comment;
        this.vote = vote;
    }

    public UserModel getUserID(){
        return this.user;
    }
    public MovieModel getMovieID(){
        return this.movie;
    }
    public CommentModel getCommentID(){
        return this.comment;
    }
    public VoteModel getVoteID(){
        return this.vote;
    }
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setUserID(UserModel user){
        this.user = user;
    }
    public void setMovieID(MovieModel movie){
        this.movie = movie;
    }
    public void setComment(CommentModel comment) {
        this.comment = comment;
    }
    public void setVote(VoteModel vote){
        this.vote = vote;
    }


}