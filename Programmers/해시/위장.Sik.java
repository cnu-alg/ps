import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int result = 1;
        List<String> clo_key = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < clothes.length; i++){
            String keys = clothes[i][1];
            if(map.containsKey(keys)){
                map.put(keys, map.get(keys)+1);
            }
            else {
                map.put(keys,1);
                clo_key.add(keys);
            }
        }
        for (int i = 0; i < clo_key.size(); i++){
            result *= map.get(clo_key.get(i))+1;
        }
        result = result-1;
        return result;
    }
}