import Like from "../components/Likes";
import { CardHeader, CardMedia, Card, CardContent } from "@mui/material";
import { useEffect } from "react";
import axios from "axios";

interface MovieProperties {
  key: number;
  movieTitle: String;
  movieImg: String;
}

export default function Movie(props: MovieProperties) {
  const { key, movieTitle, movieImg } = props;
  console.log(key);
  useEffect(() => {
    const getLikeCounts = async () => {
      try {
        const resp = await axios.post("http://localhost:8080/movies/new", {
          id: key,
          userName: movieTitle,
        });
        console.log(resp);
      } catch (err) {
        console.error(err);
      }
    };
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
