import React from "react";
import Garage from "./CarGarage";
import NumberComponent from "./SwitchCase";
import CheckDivisibility from "./ifelse";
import UserDetails from "./logicalOR";
import StudentstList from "./StudentLists";
function App() {
  const user1 = ["PAN"]; 
  const user2 = ["Aadhar", "PAN"]; 
  const user3 = ["Voter ID"]; 
  return (
    <div>
      <h1> 1.REACT PROGRAM USING MAP FUNCTION</h1>
      <Garage />
      <h1> 2.SWITCH CASE - REACT CONDITION RENDERING</h1>
      <NumberComponent num ="10" />
      <h1>3.IF-ELSE CONDITION</h1>
      <CheckDivisibility num= "272" />
      <h1>4.LOGICAL OR CONDITION</h1>
      <UserDetails details ={user1} />
      <UserDetails details ={user2} />
      <UserDetails details ={user3} />
      <h1>5.STUDENTS LISTS</h1>
      <StudentstList/>
    </div>

  );
}

export default App;
