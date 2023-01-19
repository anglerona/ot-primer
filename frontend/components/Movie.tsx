import Like from "../components/Likes";
import { CardHeader, CardMedia, Card, CardContent } from "@mui/material";
import { useEffect } from "react";
import axios from "axios";

interface MovieProperties {
  movieTitle: String;
  movieImg: String;
  movieId: number;
}

export default function Movie(props: MovieProperties) {
  const { movieTitle, movieImg, movieId } = props;
  console.log(movieId)
  const getLikeCounts = async () => {
    try {
      const resp = await axios.post("http://localhost:8080/movie/new", {
        id: movieId,
        name: movieTitle,
      });
      console.log(resp);
    } catch (err) {
      console.error(err);
    }
  };
  useEffect(() => {
    getLikeCounts();
  }, []);

  return (
    <Card sx={{ width: 200 }}>
      <div id="single-movie-container">
        <CardHeader
          titleTypographyProps={{
            fontSize: 15,
          }}
          title={movieTitle}
        />
        <CardMedia
          component="img"
          height="194"
          image={"https://image.tmdb.org/t/p/original/" + movieImg}
          alt="Movie Poster"
        />
        <CardContent>
          <Like isStatic={true}></Like>
        </CardContent>
      </div>
    </Card>
  );
}
