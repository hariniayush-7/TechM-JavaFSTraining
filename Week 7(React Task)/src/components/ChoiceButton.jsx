import React from 'react';
import PropTypes from 'prop-types';

const ChoiceButton = ({ choice, onClick }) => {
  return (
    <button className="choice-button btn btn-primary" onClick={onClick}>
      {choice}
    </button>
  );
};

ChoiceButton.propTypes = {
  choice: PropTypes.string.isRequired,
  onClick: PropTypes.func.isRequired,
};

export default ChoiceButton;