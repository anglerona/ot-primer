import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Autocomplete from "@mui/material/Autocomplete";
import Button from "@mui/material/Button";
import Grid from "@mui/material/Grid";

interface Movies {
  movies: String[];
}

export default function AddComment({ movies }: Movies) {
  return (
    <Box
      sx={{
        width: 800,
        height: 200,
        backgroundColor: "#d9d9d9 ",
      }}
    >
      <Grid
        container
        sx={{ height: "100%" }}
        alignItems="center"
        justifyContent="center"
        spacing={2}
      >
        <Grid item xs={12}>
          <Box display="flex" justifyContent="center" alignItems="center">
            <TextField
              sx={{ width: "75%", backgroundColor: "white" }}
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
            Submit Comment
          </Button>
        </Grid>
      </Grid>
    </Box>
  );
}
