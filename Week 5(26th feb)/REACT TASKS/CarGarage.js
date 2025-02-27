import React from "react";

function Car(props) {
  return <li> {props.brand} </li>;
}

function Garage() {
  const cars = [
    { id: 1, brand: "Ferrari" },
    { id: 2, brand: "Lamborghini" },
    { id: 3, brand: "Mustang" },
  ];
  return (
    <>
      <h2>What are the Beauties present in my garage </h2>
      <ul>
        {cars.map((car) => (
          <Car key={car.id} brand={car.brand} />
        ))}
      </ul>
    </>
  );
}
export default Garage;
