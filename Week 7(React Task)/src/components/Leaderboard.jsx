import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../App.css';

const Leaderboard = () => {
  const [leaderboard, setLeaderboard] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const storedLeaderboard = JSON.parse(localStorage.getItem('leaderboard')) || [];
    setLeaderboard(storedLeaderboard);
  }, []);

  const handleBackToGame = () => {
    navigate('/');
  };

  return (
    <div className="leaderboard">
      <h1>Leaderboard</h1>
      {leaderboard.map((entry, index) => (
        <div key={index} className="score-entry">
          <span>{entry.name}</span>
          <span>Player: {entry.player}</span>
          <span>Computer: {entry.computer}</span>
        </div>
      ))}
      <button onClick={handleBackToGame} className="btn btn-primary">Back to Game</button>
    </div>
  );
};

export default Leaderboard;