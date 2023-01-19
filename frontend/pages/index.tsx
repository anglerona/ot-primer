import { useState } from "react";
import axios from "axios";
import React from "react";

export default function Home() {
  const [username, setUsername] = useState("");

  const handleUser = (e) => {
    setUsername(e.target.value);
  };
  const submitUser = async () => {
    const resp = await axios.post("http://localhost:8080/user/new", {
      id: username,
      userName: username,
    });
    resp.data.json;
  };

  return (
    <form
      action={`/main?user=${username}`}
      method="POST"
      id="login-container"
      onClick={(e) => submitUser()}
    >
      <div id="column">Welcome</div>
      <label style={{ marginRight: "70px" }} id="column">
        Username:{" "}
        <input
          type="text"
          name="name"
          value={username}
          onChange={(e) => handleUser(e)}
          required
        ></input>
      </label>
      <div id="column">
        <input type="submit" value="Login / Sign Up" />
      </div>
    </form>
  );
}
