import React from "react";

// Import the component
import CheckDivisibility from "./CheckDivisibility"; 
import CheckStringLength from "./CheckStringLength";
import CheckMultipleOf3 from "./CheckMultipleOf3";
import CheckVowel from "./CheckVowel";
import CheckFlower from "./CheckFlower";

function App() {
  return (
    <div>
      <h1>TASK 1</h1>
      <CheckDivisibility num={15} />
      <h1>TASK 2</h1>
      <CheckStringLength str={"Hello"} />
      <h1>TASK 3</h1>
      <CheckMultipleOf3 arr={[9, 5, 24, 8]} />
      <h1>TASK 4</h1>
      <CheckVowel str="hello" /> 
      <CheckVowel str="sky" /> 
      <CheckVowel str="ReactJS" /> 
      <h1>TASK 5</h1>
      <CheckFlower /> 
    </div>
  );
}

export default App;
