import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import ChoiceButton from './ChoiceButton';
import Scoreboard from './Scoreboard';
import '../App.css';

const Game = ({ score, setScore }) => {
  const [playerName, setPlayerName] = useState('');
  const [playerChoice, setPlayerChoice] = useState('');
  const [computerChoice, setComputerChoice] = useState('');
  const [result, setResult] = useState('');
  const navigate = useNavigate();

  const choices = ['rock', 'paper', 'scissors'];

  const handleChoice = (choice) => {
    setPlayerChoice(choice);
    const computerChoice = choices[Math.floor(Math.random() * choices.length)];
    setComputerChoice(computerChoice);

    let result = 'draw';
    if (
      (choice === 'rock' && computerChoice === 'scissors') ||
      (choice === 'paper' && computerChoice === 'rock') ||
      (choice === 'scissors' && computerChoice === 'paper')
    ) {
      result = 'win';
    } else if (choice !== computerChoice) {
      result = 'lose';
    }

    setResult(result);
    if (result === 'win') {
      setScore({ ...score, player: score.player + 1 });
    } else if (result === 'lose') {
      setScore({ ...score, computer: score.computer + 1 });
    }
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const name = event.target.elements.playerName.value;
    setPlayerName(name);
  };

  const handleViewLeaderboard = () => {
    if (window.confirm('The game will be over if you choose to view the leaderboard. Do you want to continue?')) {
      const storedLeaderboard = JSON.parse(localStorage.getItem('leaderboard')) || [];
      const newEntry = { name: playerName, player: score.player, computer: score.computer };
      const updatedLeaderboard = [...storedLeaderboard, newEntry];
      localStorage.setItem('leaderboard', JSON.stringify(updatedLeaderboard));
      setPlayerName('');
      setPlayerChoice('');
      setComputerChoice('');
      setResult('');
      setScore({ player: 0, computer: 0 });
      navigate('/leaderboard');
    }
  };

  return (
    <div className="game">
      <h1>Rock-Paper-Scissors</h1>
      {!playerName ? (
        <form onSubmit={handleSubmit} className="input-box">
          <div className="mb-3">
            <label htmlFor="playerName" className="form-label">Enter your name:</label>
            <input type="text" className="form-control" id="playerName" name="playerName" required />
          </div>
          <button type="submit" className="btn btn-primary">Start Game</button>
        </form>
      ) : (
        <>
          <h2>Welcome, {playerName}!</h2>
          <Scoreboard score={score} />
          <div className="choices">
            {choices.map((choice) => (
              <ChoiceButton key={choice} choice={choice} onClick={() => handleChoice(choice)} />
            ))}
          </div>
          <div className="result">
            <p>Player Choice: {playerChoice}</p>
            <p>Computer Choice: {computerChoice}</p>
            <p>Result: {result}</p>
          </div>
          <button onClick={handleViewLeaderboard} className="btn btn-secondary">View Leaderboard</button>
        </>
      )}
    </div>
  );
};

export default Game;