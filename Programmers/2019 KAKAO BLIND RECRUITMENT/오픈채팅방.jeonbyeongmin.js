function solution(record) {
  const userObj = {};

  record.map((line) => {
    const [action, uid, nickname] = line.split(" ");

    if (action !== "Leave") {
      userObj[uid] = nickname;
    }
  });

  const myRecord = record.filter((item) => item.split(" ")[0] !== "Change");

  const solution = myRecord.map((line) => {
    const [action, uid, _] = line.split(" ");

    if (action === "Enter") return `${userObj[uid]}님이 들어왔습니다.`;
    if (action === "Leave") return `${userObj[uid]}님이 나갔습니다.`;
  });

  return solution;
}
