import java.util.HashMap;
import java.util.Map;
class Main{
	public static void main(String[] args){
		String[] want = new String[]{"banana", "apple", "rice", "pork", "pot"};
		int[] number = new int[]{3, 2, 2, 2, 1};
		String[] discount = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

		Solution sol = new Solution();
		System.out.println( 3 == sol.solution(want, number, discount));
	}

}
class Solution {
    final int USER_QUALIFICATION_DURATION = 10;

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        //wantMap 초기화 및 필요한 상품 추가
        Map<String, Integer> wantMap = new HashMap<String, Integer>();
        for (int i = 0; i < want.length; i++) {
            String s = want[i];
            int count = number[i];

            wantMap.put(s, count);
        }

        //discountMap 초기화 및 처음 10일치의 상품 추가
        Map<String, Integer> discountMap = new HashMap<String, Integer>();
        for (int i = 0; i < USER_QUALIFICATION_DURATION; i++) {
            String addItem = discount[i];
            discountMap.put(addItem, discountMap.getOrDefault(addItem, 0) + 1);
        }

        //처음 10일치의 상품이 추가된 상태에서 isEqual 메서드를 실행하여 answer의 값을 변경한다.
        if (isEqual(wantMap, discountMap)) {
            answer++;
        }

        //두번째날부터는 삭제할 상품 과 추가할 상품을 지정하여 discountMap을 업데이트 하고
        //업데이트 된 내용을 바탕으로 isEqual 메서드를 실행하여 answer의 값을 변경한다.
        for (int i = 1; i <= discount.length - USER_QUALIFICATION_DURATION; i++) {
            String deleteItem = discount[i - 1];
            discountMap.put(deleteItem, discountMap.get(deleteItem) - 1);

            String addItem = discount[i - 1 + USER_QUALIFICATION_DURATION];
            discountMap.put(addItem, discountMap.getOrDefault(addItem, 0) + 1);

            if (isEqual(wantMap, discountMap)) {
                answer++;
            }
        }


        return answer;
    }

    public boolean isEqual(Map<String, Integer> wantMap, Map<String, Integer> compareMap) {
        for (String key : wantMap.keySet()) {
            if (!compareMap.containsKey(key) || wantMap.get(key) != compareMap.get(key)) {
                return false;
            }
        }

        return true;
    }
}
