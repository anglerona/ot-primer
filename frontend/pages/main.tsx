import Link from "next/link";
import axios from "axios";
import { useEffect, useState } from "react";
import Movie from "../components/Movie";
import Comment from "../components/Comment";
import AddComment from "../components/AddComment";

interface MovieProperties {
  title: String;
  id: number;
  poster_path: String;
}

interface CommentProperties {
  comment: String;
  userID: String;
  reviewID: number;
}

export default function Home() {
  const [movieList, setMovieList] = useState<MovieProperties[]>([]);
  const [comments, setComments] = useState<CommentProperties[]>([
    { comment: "Good Movie", userID: "user100", reviewID: 123023 },
    { comment: "Decent Movie", userID: "user24", reviewID: 123024 },
  ]);

  const [username, setUsername] = useState("");

  useEffect(() => {
    if (typeof window !== "undefined") {
      const queryParams = new URLSearchParams(window.location.search);
      setUsername(queryParams.get("user") || "");
    }
    const sendGetRequest = async () => {
      try {
        const resp = await axios.get(
          "http://localhost:8080/all/movies"
        );
        setMovieList(resp.data.results.slice(0, 5));
      } catch (err) {
        console.error(err);
      }
    };
    const getComments = async () => {
      try {
        const resp = await axios.get("add url");
        setComments(resp.data.results);
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

  const listComments = comments.map((comment) => (
    <>
      <Comment
        key={comment.reviewID}
        userID={comment.userID}
        comment={comment.comment}
      ></Comment>
      <br></br>
    </>
  ));

  return (
    <>
      <nav>
        <div className="user-name">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className="icon icon-tabler icon-tabler-user"
            width={24}
            height={24}
            viewBox="0 0 24 24"
            stroke-width={2}
            stroke="currentColor"
            fill="black"
            strokeLinecap="round"
            strokeLinejoin="round"
          >
            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
            <circle cx={12} cy={7} r={4}></circle>
            <path d="M6 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2"></path>
          </svg>
          {username}
        </div>
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
        }}
      >
        Top 5 Movies within the Last 24 Hours
      </h3>
      <div id="movie-container">{listItems}</div>
      <div id="comment-container">
        <a>Comments</a>
        <AddComment
          movies={Array.from(movieList, (movie) => movie.title)}
        ></AddComment>
        <a>All Comments</a>
        <br></br>
        <div>{listComments}</div>
        <br></br>
      </div>
    </>
  );
}
