import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}

// 첫코드
//class Solution {
//    public String solution(String[] participant, String[] completion) {
//
//        List<String> part = new ArrayList<>(Arrays.asList(participant));
//
//        for (int i = 0; i < completion.length; i++){
//            for (int j = 0; j < part.size(); j++){
//                if(completion[i].equals(part.get(j))){
//                    part.remove(j);
//                    break;
//                }
//            }
//        }
//
//        return part.get(0);
//    }
//}