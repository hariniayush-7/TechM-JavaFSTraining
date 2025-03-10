import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Game from './components/Game';
import Leaderboard from './components/Leaderboard';
import './App.css';

function App() {
  const [score, setScore] = useState({ player: 0, computer: 0 });

  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Game score={score} setScore={setScore} />} />
          <Route path="/leaderboard" element={<Leaderboard score={score} />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;