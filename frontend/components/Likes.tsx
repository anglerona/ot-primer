import { useState } from "react";
import { ThumbUpOffAlt, ThumbDown } from "@mui/icons-material";
import { Box, Grid, Divider } from "@mui/material";
interface LikeProperties {
  isStatic: boolean;
}

export default function Likes(props: LikeProperties) {
  const { isStatic } = props;
  const [likeCount, setLikeCount] = useState(0);
  const [dislikeCount, setDislikeCount] = useState(0);

  const [activeBtn, setActiveBtn] = useState("none");

  const handleLikeClick = () => {
    if (activeBtn === "none") {
      setLikeCount(likeCount + 1);
      setActiveBtn("like");
      return;
    }

    if (activeBtn === "like") {
      setLikeCount(likeCount - 1);
      setActiveBtn("none");
      return;
    }

    if (activeBtn === "dislike") {
      setLikeCount(likeCount + 1);
      setDislikeCount(dislikeCount - 1);
      setActiveBtn("like");
    }
  };

  const handleDisikeClick = () => {
    if (activeBtn === "none") {
      setDislikeCount(dislikeCount + 1);
      setActiveBtn("dislike");
      return;
    }

    if (activeBtn === "dislike") {
      setDislikeCount(dislikeCount - 1);
      setActiveBtn("none");
      return;
    }

    if (activeBtn === "like") {
      setDislikeCount(dislikeCount + 1);
      setLikeCount(likeCount - 1);
      setActiveBtn("dislike");
    }
  };

  return (
    <div style={{ display: "flex", justifyContent: "space-evenly" }}>
      {!isStatic && (
        <button
          className={`btn ${activeBtn === "like" ? "like-active" : ""}`}
          onClick={handleLikeClick}
        >
          <span>
            <ThumbUpOffAlt />{" "}
          </span>
          {likeCount}
        </button>
      )}

      {!isStatic && (
        <button
          className={`btn ${activeBtn === "dislike" ? "dislike-active" : ""}`}
          onClick={handleDisikeClick}
        >
          <span>
            <ThumbDown />{" "}
          </span>{" "}
          {dislikeCount}
        </button>
      )}

      {isStatic && (
        <Box
          sx={{
            display: "flex",
            flexDirection: "row",
            justifyContent: "space-evenly",
            alignItems: "center",
            backgroundColor: "#d9d9d9 ",
            gap: "7%",
            padding: "3% 12% 3% 12%",
            borderRadius: "25px",
            boxShadow: "0 2px 4px 0 rgba(0, 0, 0, 0.2)",
          }}
        >
          <ThumbUpOffAlt />
          {likeCount}
          <Divider orientation="vertical" flexItem></Divider>
          {dislikeCount}
          <ThumbDown />
        </Box>
      )}
    </div>
  );
}
