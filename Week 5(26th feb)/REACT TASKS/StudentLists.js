import React from "react";

function StudentstList() {
  const list = [
    { name: "Harini", dept: "ECE" },
    { name: "Nazhiya", dept: "EEE" },
    { name: "Kiruthiga", dept: "AIDS" },
    { name: "Deepa", dept: "IT" },
  ];

  return (
    <>
      <h2>LIST OF STUDENTS PRESENT IN 123 B</h2>
      <ul>
        {list.map((details) => (
            <li>
                {" "}
                Name:{details.name} , Department: {details.dept} {" "}
            </li>
        ))}
      </ul>
    </>
  );
}
export default StudentstList;