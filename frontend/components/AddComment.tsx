import { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Autocomplete from "@mui/material/Autocomplete";
import Button from "@mui/material/Button";

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
      <TextField id="outlined-basic" label="Comment" variant="outlined" />
      <Autocomplete
        disablePortal
        id="combo-box-demo"
        options={movies}
        sx={{ width: 200 }}
        renderInput={(params) => <TextField {...params} label="Select Movie" />}
      />
      <Button variant="outlined">Submit Comment</Button>
    </Box>
  );
}
