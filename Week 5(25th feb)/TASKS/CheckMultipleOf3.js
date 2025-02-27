import React from "react";

function MultipleOfThree(props) {
    return <p>The number of elements in the array [{props.arr.join(", ")}] is multiple of 3.</p>;
}

function NotMultipleOfThree(props) {
    return <p>The number of elements in the array [{props.arr.join(", ")}] is not a multiple of 3.</p>;
}

function CheckMultipleOf3(props) {
    const arrayLength = props.arr.length;
    
    if (arrayLength % 3 === 0) {
        return <MultipleOfThree arr={props.arr} />;
    }
    return <NotMultipleOfThree arr={props.arr} />;
}

export default CheckMultipleOf3;
