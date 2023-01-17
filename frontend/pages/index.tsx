import Link from "next/link";

export default function Home() {
  return (
    <>
      <form id="login-container">
        <label>
          Username:
          <input type="text" name="name" />
        </label>
        <div>
          <Link href="/main">
            <input type="submit" value="Login / Sign Up" />
          </Link>
        </div>
      </form>
    </>
  );
}
