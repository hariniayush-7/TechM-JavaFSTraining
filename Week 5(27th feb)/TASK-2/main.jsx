import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
// import Task1 from './27th_feb/task1.jsx'
// import Hi from './27th_feb/hi.jsx'
// import Gm from './27th_feb/gm.jsx'
// import Today from './27th_feb/today.jsx'
// import Task1Completed from './27th_feb/task1Complete.jsx'
// import ABComponent2 from './27thTasks/uuid.jsx'
import Component1 from './c1.jsx'
import Component2 from './f1/c2.jsx'



createRoot(document.getElementById('root')).render(
  <StrictMode>
 <Component1/>
 <Component2/>
    
  </StrictMode>,
)
