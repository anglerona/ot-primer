import { Box, TextField, Autocomplete, Button, Grid } from "@mui/material";
import Like from "../components/Likes";
import axios from "axios";
import { useState, useEffect } from "react";
import { isConstructorDeclaration } from "typescript";
import Router from "next/router";

interface Movies {
  movies: MovieProperties[];
}

interface MovieProperties {
  title: String;
  id: number;
  poster_path: String;
}

interface User {
  username: String;
}

interface Review extends Movies, User {}

export default function AddComment({ movies, username }: Review) {
  const [comment, setComment] = useState("");
  const [movie, setMovie] = useState(0);
  const [vote, setVote] = useState(0);

  const handleComment = (e) => {
    console.log(e.target.value);
    setComment(e.target.value);
  };

  const handleMovie = (event, value) => {
    let movieid = 0;
    for(let i = 0; i < 5; i++){
      if(movies[i].title == value){
        movieid = movies[i].id;
        break;
      }
    }
    setMovie(movieid);
  };

  const submitComment = async () => {
    const resp = await axios.post("http://localhost:8080/review", {
      user: { id: username },
      comment: { body: comment },
      movie: { id: movie },
      vote: {likeDislike: vote}
    });
    resp.data.json;
    Router.reload();
  };

  return (
    <Box
      sx={{
        width: 800,
        backgroundColor: "#d9d9d9 ",
        paddingTop: 2,
        paddingBottom: 2,
      }}
    >
      <Grid
        container
        sx={{ height: "100%" }}
        alignItems="center"
        justifyContent="center"
        spacing={1}
      >
        <Grid item xs={12}>
          <Box display="flex" justifyContent="center" alignItems="center">
            <TextField
              sx={{ width: "85%", backgroundColor: "white" }}
              size="medium"
              id="outlined-basic"
              label="Comment"
              variant="outlined"
              required
              onChange={handleComment}
            />
          </Box>
        </Grid>
        <Grid item xs={4}>
          <Autocomplete
            disablePortal
            id="combo-box-demo"
            options={Array.from(movies, (movie) => movie.title)}
            sx={{ width: "100%", backgroundColor: "white" }}
            onChange={handleMovie}
            renderInput={(params) => (
              <TextField required {...params} label="Select Movie" />
            )}
          />
        </Grid>
        <Grid item xs={2}>
          <Like isStatic={false} setVote={setVote}></Like>
        </Grid>
        <Grid item xs={4}>
          <Button
            sx={{
              color: "black",
              borderColor: "gray",
              backgroundColor: "white",
              width: "80%",
            }}
            onClick={submitComment}
            variant="outlined"
          >
            Submit Review
          </Button>
        </Grid>
      </Grid>
    </Box>
  );
}
