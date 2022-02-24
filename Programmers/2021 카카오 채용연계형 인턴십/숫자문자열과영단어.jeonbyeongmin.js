function solution(s) {
  const words = {
    zero: "0",
    one: "1",
    two: "2",
    three: "3",
    four: "4",
    five: "5",
    six: "6",
    seven: "7",
    eight: "8",
    nine: "9",
  };

  let line = "";
  let answer = "";
  const input = s.split("");

  input.map((alpha) => {
    line += alpha;
    if (Number(alpha) === 0 || Number(alpha)) {
      answer += alpha;
      line = "";
    }
    if (words[line] !== undefined) {
      answer += words[line];
      line = "";
    }
  });

  return Number(answer);
}

function betterSolution(s) {
  let numbers = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  ];

  let answer = s;

  numbers.map((number, index) => {
    const arr = answer.split(number);
    answer = arr.join(index);
  });

  return Number(answer);
}
