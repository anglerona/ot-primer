import { Box, TextField, Autocomplete, Button, Grid } from "@mui/material";
import Like from "../components/Likes";

interface Movies {
  movies: String[];
}

export default function AddComment({ movies }: Movies) {
  return (
    <Box
      sx={{
        width: 800,
        backgroundColor: "#d9d9d9 ",
        paddingTop: 2,
        paddingBottom: 2,
      }}
    >
      <Grid
        container
        sx={{ height: "100%" }}
        alignItems="center"
        justifyContent="center"
        spacing={1}
      >
        <Grid item xs={12}>
          <Box display="flex" justifyContent="center" alignItems="center">
            <TextField
              sx={{ width: "85%", backgroundColor: "white" }}
              size="medium"
              id="outlined-basic"
              label="Comment"
              variant="outlined"
            />
          </Box>
        </Grid>
        <Grid item xs={4}>
          <Autocomplete
            disablePortal
            id="combo-box-demo"
            options={movies}
            sx={{ width: "100%", backgroundColor: "white" }}
            renderInput={(params) => (
              <TextField {...params} label="Select Movie" />
            )}
          />
        </Grid>
        <Grid item xs={2}>
          <Like></Like>
        </Grid>
        <Grid item xs={4}>
          <Button
            sx={{
              color: "black",
              borderColor: "gray",
              backgroundColor: "white",
              width: "80%",
            }}
            variant="outlined"
          >
            Submit Review
          </Button>
        </Grid>
      </Grid>
    </Box>
  );
}
