import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import Task1 from './27th_feb/task1.jsx'
import Hi from './27th_feb/hi.jsx'
import Gm from './27th_feb/gm.jsx'
import Today from './27th_feb/today.jsx'
import Task1Completed from './27th_feb/task1Complete.jsx'
import ABComponent2 from './27thTasks/uuid.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Hi/>
    <Gm/>
    <Today/>
    <Task1/>
    <Task1Completed/>
    <ABComponent2/>
    
  </StrictMode>,
)
