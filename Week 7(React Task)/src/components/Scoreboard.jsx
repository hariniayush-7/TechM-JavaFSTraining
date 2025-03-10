import React from 'react';
import PropTypes from 'prop-types';
import '../App.css';

const Scoreboard = ({ score }) => {
  return (
    <div className="scoreboard">
      <h2>Scoreboard</h2>
      <p>Player: {score.player}</p>
      <p>Computer: {score.computer}</p>
    </div>
  );
};

Scoreboard.propTypes = {
  score: PropTypes.shape({
    player: PropTypes.number.isRequired,
    computer: PropTypes.number.isRequired,
  }).isRequired,
};

export default Scoreboard;