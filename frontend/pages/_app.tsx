import "../styles/globals.css";
import "../public/globals.css";
import type { AppProps } from "next/app";

function MyApp({ Component, pageProps }: AppProps) {
  console.log("app main");
  return <Component {...pageProps} />;
}

export default MyApp;
