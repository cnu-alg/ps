const TOOTHBRUSH_PRICE = 100;
const MIN_PROFIT = 1;

function solution(enroll, referral, seller, amount) {
  const money = amount.map((number) => number * TOOTHBRUSH_PRICE);

  const sellerInfo = {};

  enroll.map((person, idx) => {
    sellerInfo[person] = {
      referral: referral[idx],
      totalProfit: 0,
    };
  });

  seller.map((person, idx) => {
    let restProfit = money[idx];
    let restReferralProfit = 0;
    let currentPerson = person;

    while (currentPerson !== "-" && restProfit !== 0) {
      const devidedProfit = Math.floor(restProfit / 10);

      // devidedProfit 이 MIN_PROFIT 보다 크거나 같을 땐 추천인한테 돈 뜯기고
      if (devidedProfit >= MIN_PROFIT) {
        sellerInfo[currentPerson].totalProfit += restProfit - devidedProfit;
        restReferralProfit = devidedProfit;
      }
      // devidedProfit 이 MIN_PROFIT 보다 작을 땐 추천인한테 돈 안주고 낼름한다.
      else {
        sellerInfo[currentPerson].totalProfit += restProfit;
        restReferralProfit = 0;
      }
      currentPerson = sellerInfo[currentPerson].referral;
      restProfit = restReferralProfit;
    }
  });

  const result = enroll.map((person) => {
    return sellerInfo[person].totalProfit;
  });

  return result;
}
