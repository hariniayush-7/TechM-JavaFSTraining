import React, { useState } from "react";

function CheckFlower() {
    const flowers = ["Rose", "Jasmine", "Lotus"]; // Flower array
    const [input, setInput] = useState(""); // State to store input
    const [message, setMessage] = useState(""); // State to store result message

    const handleCheck = () => {
        if (flowers.includes(input)) {
            setMessage(`${input} is a flower.`);
        } else {
            setMessage(`${input} is not a flower.`);
        }
    };

    return (
        <div>
            <h2>Check Flower</h2>
            <input 
                type="text" 
                placeholder="Enter flower name" 
                value={input} 
                onChange={(e) => setInput(e.target.value)}
            />
            <button onClick={handleCheck}>Check</button>
            <p>{message}</p>
        </div>
    );
}

export default CheckFlower;
