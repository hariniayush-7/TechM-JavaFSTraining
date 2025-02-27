import React from "react";

function DivisibleBy16(props) {
  return <p>The given number {props.num} is divisible by 16</p>;
}
function NotDivisibleBy16(props) {
  return <p>The given number {props.num} is not divisible by 16</p>;
}
function CheckDivisibility(props) {
  const isNum = Number(props.num);
  if (isNum % 2 === 0) {
    return <DivisibleBy16 num={isNum} />;
  } else {
    return <NotDivisibleBy16 num={isNum} />;
  }
}
export default CheckDivisibility;
