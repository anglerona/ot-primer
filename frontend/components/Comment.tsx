import { Box, Grid } from "@mui/material";
import {
  ThumbUpOffAlt,
  ThumbDown,
  ThumbUp,
  ThumbDownAltOutlined,
  SettingsVoiceTwoTone,
  ThumbDownAlt,
} from "@mui/icons-material";

interface CommentProperties {
  comment: String;
  userID: String;
  key: number;
  movieTitle: String;
  vote: number;
}

export default function Comment(props: CommentProperties) {
  const { comment, userID, movieTitle, vote } = props;
  console.log(props);
  const voteIcon = () => {
    if (vote === 1) {
      return (
        <>
          <ThumbUp />{" "}
        </>
      );
    } else {
      return (
        <>
          <ThumbDownAlt />{" "}
        </>
      );
    }
  };
  return (
    <Box
      sx={{
        width: 800,
        backgroundColor: "#d9d9d9 ",
      }}
    >
      <Grid
        container
        sx={{ height: "100%" }}
        alignItems="center"
        spacing={2}
        padding="2%"
      >
        <Grid item xs={8}>
          {comment}
        </Grid>
        <Grid item xs={4}>
          {movieTitle}
          <Grid item xs={3}>
            {voteIcon()}
          </Grid>
        </Grid>

        <Grid item xs={8}>
          {userID}
        </Grid>
      </Grid>
    </Box>
  );
}
