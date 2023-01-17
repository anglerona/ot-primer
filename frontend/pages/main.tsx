import Link from "next/link";
import axios from "axios";
import { useEffect, useState } from "react";

interface MovieProperties {
  title: String;
  id: number;
  poster_path: String;
}
const MOVIEPATH = "https://image.tmdb.org/t/p/original/";

export default function Home() {
  const [movieList, setMovieList] = useState<MovieProperties[]>([]);

  useEffect(() => {
    const sendGetRequest = async () => {
      try {
        const resp = await axios.get(
          "https://api.themoviedb.org/3/trending/movie/day?api_key=781cd82e7790ae7403010d9f126bcc2c"
        );
        setMovieList(resp.data.results.slice(0, 5));
      } catch (err) {
        console.error(err);
      }
    };
    sendGetRequest();
  }, []);
  const listItems = movieList.map((movie) => (
    <div key={movie.id} id="single-movie-container">
      <a>{movie.title}</a>
      <img alt="Movie Poster" src={MOVIEPATH + movie.poster_path}></img>
    </div>
  ));

  return (
    <>
      <div>
        <Link href="/">
          <input type="submit" value="Logout" />
        </Link>
      </div>
      <div id="movie-container">{listItems}</div>
    </>
  );
}
