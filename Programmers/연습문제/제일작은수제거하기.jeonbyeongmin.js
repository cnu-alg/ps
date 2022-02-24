function solution(arr) {
  const minNumber = Math.min(...arr);
  const answer = arr.filter((number) => number !== minNumber);
  return answer.length === 0 ? [-1] : answer;
}
