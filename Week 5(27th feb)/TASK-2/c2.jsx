import {useState} from 'react'
import React , {Suspense,lazy} from "react";
import "../App.css";
const Component3 = React.lazy(() => import('./c3.jsx'));
import Component5 from "@f2/C5"; // ✅ Statically import C5
const Component4 = lazy(() => import("@f2/C4")); // ✅ Dynamic import using alias

export default function Component2()
{
    return (
        <>
           <h1>This is the second component</h1>
           <Suspense fallback={<h1>Loading...</h1>}>
           <Component3 />
           <Component4/>
           <Component5/>
           </Suspense>
        </>
      )
}

