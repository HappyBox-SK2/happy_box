import React from "react";
import logo from "./logo.svg";
import piggyBank from "./images/piggy_bank.jpeg";
import "./App.css";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        <img src={piggyBank} alt="piggy_bank" />
        <p>우리 함께 행복을 저금해보아요!</p>
      </header>
    </div>
  );
}

export default App;
