import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
     public int[] solution(String[] gems) {
        // field 선언
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> jewerly = new HashSet<String>();
        HashMap<String, Integer> interval = new HashMap<String, Integer>();
        int idx = 0;
        int length = Integer.MAX_VALUE;
        int start = 0;
    
        // 보석 중복 제거
        for (String gem : gems) {
            jewerly.add(gem);
        }

        for (String gem : gems) { // 모든 지점을 시작점으로 두고 반복
            queue.add(gem);
            interval.put(gem, interval.getOrDefault(gem, 0) + 1);

            while (true) {
                String temp = queue.peek();
                if (interval.get(temp) > 1) { // 보석이 연달아 나오는 경우
                    queue.poll();
                    interval.put(temp, interval.get(temp) - 1); // 개수 삭제
                    idx++; // 시작점 + 1
                } else break;
            }

            if (interval.size() == jewerly.size() && length > queue.size()) {
                length = queue.size();
                start = idx;
            }
        }


        return new int[]{start + 1, start + length};
    }
}
