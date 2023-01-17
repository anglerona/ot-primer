import Like from "../components/Likes";

interface MovieProperties {
  movieTitle: String;
  movieImg: String;
}

export default function Movie(props: MovieProperties) {
  const { movieTitle, movieImg } = props;
  return (
    <div id="single-movie-container">
      <a>{movieTitle}</a>
      <img
        alt="Movie Poster"
        src={"https://image.tmdb.org/t/p/original/" + movieImg}
      ></img>
      <Like></Like>
    </div>
  );
}
