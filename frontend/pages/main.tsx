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

interface CommentProperties {
  comment: String;
  userID: String;
  reviewID: number;
}

export default function Home() {
  const userName = useSearchParams().get("username");

  const [movieList, setMovieList] = useState<MovieProperties[]>([]);
  const [comments, setComments] = useState<CommentProperties[]>([
    { comment: "Good Movie", userID: "user100", reviewID: 123023 },
  ]);

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
    const getComments = async () => {
      try {
        const resp = await axios.get("add url");
        setComments(resp.data.results);
      } catch (err) {
        console.error(err);
      }
    };
    sendGetRequest();

    // call getcomments here
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
    <Comment
      key={comment.reviewID}
      userID={comment.userID}
      comment={comment.comment}
    ></Comment>
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
          {userName}
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
          paddingTop: "70px",
        }}
      >
        Top 5 Movies within the last 24 Hours
      </h3>
      <div id="movie-container">{listItems}</div>
      <div id="comment-container">
        <AddComment
          movies={Array.from(movieList, (movie) => movie.title)}
        ></AddComment>
        <div id="comments-container">{listComments}</div>
      </div>
    </>
  );
}
