import Movie from "./Movie";
interface CommentProperties {
  comment: String;
  userID: String;
  key: number;
}

export default function Comment(props: CommentProperties) {
  const { comment, userID } = props;
  return (
    <div id="single-comment-container">
      <div>
        {comment}
        {userID}
      </div>
      <div></div>
    </div>
  );
}
