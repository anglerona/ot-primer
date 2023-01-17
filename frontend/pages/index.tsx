import Link from "next/link";
import { useState, useEffect } from "react";
import axios from "axios";

export default function Home() {
  const [username, setUsername] = useState("");

  const handleUser = (e) => {
    setUsername(e.target.value);
  };
  const submitUser = async (e) => {
    const resp = await axios.post("http://localhost:3000/", { username });
    resp.data.json;
  };

  return (
    <>
      <form id="login-container">
        <div id="column">Welcome</div>
        <label style={{ marginRight: "70px" }} id="column">
          Username:{" "}
          <input
            type="text"
            name="name"
            value={username}
            onChange={(e) => handleUser(e)}
          ></input>
        </label>
        <div id="column">
          <Link href="/main">
            <input
              type="submit"
              value="Login / Sign Up"
              onClick={(e) => submitUser(e)}
            />
          </Link>
        </div>
      </form>
    </>
  );
}
