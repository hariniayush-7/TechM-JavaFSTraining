import React from "react";
function EvenString(props)
        {
            return <p>The given string {props.str} has even length</p>;
        }
        function OddString(props)
        {
            return <p> The given string {props.str} has odd length </p>;
        }
        function CheckStringLength(props)
        {
            const isStr=String(props.str);
            if(isStr.length%2===0)
            {
                return <EvenString str = {props.str} />;
            }
            return <OddString str = {props.str} />;
        }
export default CheckStringLength;