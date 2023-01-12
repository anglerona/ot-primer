import Link from "next/link";

export default function Home() {
  return (
    <>
      <form>
        <label>
          Username:
          <input type="text" name="name" />
        </label>
        <Link href="/main">
          <input type="submit" value="Login/SignUp" />
        </Link>
      </form>
    </>
  );
}
