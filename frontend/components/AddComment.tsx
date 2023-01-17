export default function AddComment(props) {
  const { movies } = props;

  const listMovies = movies.map((movie) => {
    <option value={movie.title}>{movie.title}</option>;
  });

  return (
    <>
      <div id="add-comment-container">
        <label style={{ marginRight: "70px" }} id="column">
          <input type="text" name="name" style={{ width: "100%" }}></input>
        </label>
        <div id="add-comment-forms" style={{ justifyContent: "center" }}>
          <select name="movies" id="movie-select">
            {listMovies}
          </select>
          <button>Submit Comment</button>
        </div>
      </div>
    </>
  );
}
