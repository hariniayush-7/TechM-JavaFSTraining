import React from "react";

function DivisibleBy13(props) {
  return <p>The given number {props.num} is divisible by 13</p>;
}

function NotDivisibleBy13(props) {
  return <p>The given number {props.num} is not divisible by 13</p>;
}

function CheckDivisibility({ num }) {
  const isNum = Number(num);
  if (isNum % 13 === 0) {
    return <DivisibleBy13 num={num} />;
  }
  return <NotDivisibleBy13 num={num} />;
}

// Export the component so it can be used in App.js
export default CheckDivisibility;
