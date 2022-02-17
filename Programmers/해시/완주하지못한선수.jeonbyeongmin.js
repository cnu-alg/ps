function solution(participant, completion) {
  const participantObj = {};
  let answer = "";

  participant.map((person) => {
    participantObj[person] = participantObj[person]
      ? participantObj[person] + 1
      : 1;
  });

  completion.map((person) => {
    participantObj[person] -= 1;
  });

  Object.entries(participantObj).map((entry) => {
    const [name, value] = entry;
    if (value > 0) answer = name;
  });

  return answer;
}
