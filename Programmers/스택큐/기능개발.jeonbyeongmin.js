function solution(progresses, speeds) {
  const rest = progresses.map((item, index) =>
    Math.ceil((100 - item) / speeds[index])
  );
  let stack = [];
  const answer = [];

  rest.map((item) => {
    if (stack.length === 0) stack.push(item);
    else {
      if (stack[0] >= item) stack.push(item);
      else {
        answer.push(stack.length);
        stack = [item];
      }
    }
  });

  answer.push(stack.length);

  return answer;
}
