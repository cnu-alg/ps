function solution(id_list, report, k) {
  // 신고는 같은 사람에게 한번씩 할 수 있다.
  // 따라서 report에서 불필요한 중복 데이터 제거
  const set = new Set(report);
  const reportList = [...set];

  const reportObj = {};

  // id_list로 report를 관리하는 obj 생성
  id_list.map((uid) => {
    reportObj[uid] = {
      reportees: [],
      reportedCount: 0,
      isBlack: false,
    };
  });

  // 중복이 제거된 신고 목록을 반복문을 통해 reportObj를 업데이트 해준다.
  reportList.map((info) => {
    const [reporter, reportee] = info.split(" ");
    reportObj[reporter].reportees.push(reportee);

    if (++reportObj[reportee].reportedCount >= k) {
      reportObj[reportee].isBlack = true;
    }
  });

  // 한번이라도 신고되었던 사람이 블랙되었는지 판단하여 메일 전송 횟수를 결정해줌.
  const solution = id_list.map((uid) => {
    return reportObj[uid].reportees.filter((reporteeId) => {
      return reportObj[reporteeId].isBlack;
    }).length;
  });

  return solution;
}
