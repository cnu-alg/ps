import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int[] solution(String[] gems) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        Queue<String> queue = new LinkedList<>();
        HashSet<String> gem_set = new HashSet<>();
        HashMap<String, Integer> gem_map = new HashMap<>();
        int start = 0;
        int end = Integer.MAX_VALUE;
        int start_final = 0;
        int[] result = new int[2];

        for (String s : gems) {
            gem_set.add(s);
        }

        for (int i = 0; i < gems.length; i++) {
            gem_map.put(gems[i], gem_map.getOrDefault(gems[i], 0) + 1);
            queue.add(gems[i]);

            while (true) {
                String temp = queue.peek();
                if (gem_map.get(temp) > 1) {
                    queue.poll();
                    start++;
                    gem_map.put(temp, gem_map.get(temp) - 1);
                } else {
                    break;
                }
            }
            if (gem_map.size() == gem_set.size() && end > queue.size()) {
                end = queue.size();
                start_final = start;
            }
        }
        result[0] = start_final + 1;
        result[1] = start_final + end;
        System.out.println(result[0] +" "+ result[1]);

    }
}

// ------------------- 효율성 3개 실패 코드 -----------------------
// 이거로 통과 할 방법 없나..

//class Solution {
//    public static void main(String[] args) {
//        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        HashMap<String, Integer> gem_map = new HashMap<>();
//        int start = 0;
//        int end = 0;
//        int distance = Integer.MAX_VALUE;
//        int[] result = new int[2];
//
//        for (String gem : gems) {
//            gem_map.put(gem, 0);
//        }
//        while (true) {
//            if (!gem_map.containsValue(0)){
//                gem_map.put(gems[start], gem_map.get(gems[start])-1);
//                start++;
//            }
//            else if(end == gems.length){
//                break;
//            }
//            else {
//                gem_map.put(gems[end], gem_map.get(gems[end]) + 1);
//                end++;
//            }
//            if(!gem_map.containsValue(0)){
//                if (end - start < distance){
//                    distance = end - start;
//                    result[0] = start+1;
//                    result[1] = end;
//                }
//            }
//        }
//
//        System.out.println(result[0]+" "+result[1]);
//    }
//}