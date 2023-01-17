import Link from "next/link";
import axios from "axios";
import { useEffect, useState } from "react";
import Movie from "../components/Movie";
import Comment from "../components/Comment";
import AddComment from "../components/AddComment";

import { useSearchParams } from "next/navigation";

interface MovieProperties {
  title: String;
  id: number;
  poster_path: String;
}

export default function Home() {
  const userName = useSearchParams().get("username");

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
    <>
      <Movie
        key={movie.id}
        movieTitle={movie.title}
        movieImg={movie.poster_path}
      ></Movie>
    </>
  ));

  return (
    <>
      <nav>
        <div className="user-name">{userName}</div>
        <div className="log-out">
          <Link href="/">
            <input type="submit" value="Logout" />
          </Link>
        </div>
      </nav>

      <h3
        style={{
          textAlign: "center",
          paddingBottom: "20px",
          paddingTop: "40px",
        }}
      >
        Top 5 Movies within the last 24 Hours
      </h3>
      <div id="movie-container">{listItems}</div>
      <div id="comment-container">
        <AddComment></AddComment>
        <Comment></Comment>
      </div>
    </>
  );
}
