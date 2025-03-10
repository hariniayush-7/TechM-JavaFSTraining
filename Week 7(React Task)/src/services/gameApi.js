import axios from 'axios';

axios.interceptors.response.use((response) => {
  const { playerChoice, computerChoice } = response.config.params;
  let result = 'draw';
  if (
    (playerChoice === 'rock' && computerChoice === 'scissors') ||
    (playerChoice === 'paper' && computerChoice === 'rock') ||
    (playerChoice === 'scissors' && computerChoice === 'paper')
  ) {
    result = 'win';
  } else if (playerChoice !== computerChoice) {
    result = 'lose';
  }
  response.data = { result };
  return response;
});

export const getResult = (playerChoice, computerChoice) => {
  return axios.get('/api/game/result', {
    params: { playerChoice, computerChoice },
  });
};