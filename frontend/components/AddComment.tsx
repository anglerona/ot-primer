import { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Autocomplete from "@mui/material/Autocomplete";
import Button from "@mui/material/Button";
import Grid from "@mui/material/Grid";

interface Movies {
  movies: String[];
}

export default function AddComment({ movies }: Movies) {
  const [open, setOpen] = useState(false);

  const handleOpen = () => {
    setOpen(!open);
  };

  return (
    <Box
      sx={{
        width: 800,
        height: 200,
        backgroundColor: "#cfd8dc",
      }}
    >
      <Grid
        container
        sx={{ height: "100%" }}
        alignItems="center"
        justifyContent="center"
        spacing={0}
      >
        <Grid item xs={12}>
          <Box display="flex" justifyContent="center" alignItems="center">
            <TextField
              sx={{ width: "75%" }}
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
            sx={{ width: 200 }}
            renderInput={(params) => (
              <TextField {...params} label="Select Movie" />
            )}
          />
        </Grid>
        <Grid item xs={4}>
          <Button variant="outlined">Submit Comment</Button>
        </Grid>
      </Grid>
    </Box>
  );
}
