import { useState } from "react";

interface Movies {
  movies: MovieProperties[];
}

interface MovieProperties {
  title: String;
  id: number;
  poster_path: String;
}

export default function AddComment({ movies }: Movies) {
  const [open, setOpen] = useState(false);

  const handleOpen = () => {
    setOpen(!open);
  };

  const listMovies = movies.map((movie) => (
    <>
      <h5>{movie.title}</h5>
    </>
  ));

  return (
    <>
      <div id="add-comment-container">
        <label style={{ marginRight: "70px" }} id="column">
          <input type="text" name="name" style={{ width: "100%" }}></input>
        </label>
        <div id="add-comment-forms" style={{ justifyContent: "center" }}>
          <button onClick={handleOpen}>Dropdown</button>
          {open ? listMovies : null}
          <button>Submit Comment</button>
        </div>
      </div>
    </>
  );
}
