import Link from "next/link";
import axios from "axios";
import { useEffect, useState } from "react";

interface MovieProperties {
  title: String;
  id: number;
  poster_path: String;
}
const moviePath = "https://image.tmdb.org/t/p/original/";

export default function Home() {
  const [movieList, setMovieList] = useState<MovieProperties[]>([]);
  useEffect(() => {
    const sendGetRequest = async () => {
      try {
        const resp = await axios.get(
          "https://api.themoviedb.org/3/trending/movie/day?api_key=781cd82e7790ae7403010d9f126bcc2c"
        );
        setMovieList(resp.data.results.slice(0, 5));
        console.log(setMovieList(resp.data.results.slice(0, 5)));
      } catch (err) {
        console.error(err);
      }
    };
    sendGetRequest();
  }, []);
  const numbers = [1, 2, 3, 4, 5];
  const listItems = movieList.map((movie) => (
    <div key={movie.id}>
      {movie.title}
      <img src={moviePath + movie.poster_path}></img>
      {console.log(moviePath + movie.poster_path)}
    </div>
  ));

  return (
    <>
      <ul>{listItems}</ul>
    </>
  );
}
