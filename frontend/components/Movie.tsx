import Like from "../components/Likes";
import { CardHeader, CardMedia, Card, CardContent } from "@mui/material";
interface MovieProperties {
  movieTitle: String;
  movieImg: String;
}

export default function Movie(props: MovieProperties) {
  const { movieTitle, movieImg } = props;
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
