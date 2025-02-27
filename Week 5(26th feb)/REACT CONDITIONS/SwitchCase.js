import React from "react";

function EvenNumber()
{
    return <h3>The given number is a EvenNumber</h3>;
}

function OddNumber()
{
    return <h3>The given number is a OddNumber</h3>;
}

function NumberComponent (props)
{
    const isNum = props.num;
    const checkNo = ()=>{
        let n=(isNum%2===0);
        switch(n)
        {
            case true:
                return <EvenNumber></EvenNumber>;
            case false:
                return <OddNumber></OddNumber>;
            default: 
               return <p>Unexpected error</p>

        }
    };
    return ( <div> 
        {checkNo()}  </div>  
   )
}
export default NumberComponent;
