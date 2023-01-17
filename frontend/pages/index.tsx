import Link from "next/link";

export default function Home() {
  return (
    <>
      <form id="login-container">
        <div id="column">Welcome</div>
        <label style={{ marginRight: "70px" }} id="column">
          Username: <input type="text" name="name"></input>
        </label>
        <div id="column">
          <Link href="/main">
            <input type="submit" value="Login / Sign Up" />
          </Link>
        </div>
      </form>
    </>
  );
}
