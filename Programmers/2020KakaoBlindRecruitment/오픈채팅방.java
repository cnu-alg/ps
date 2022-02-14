import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        int n = 0; // result size
        Map<String,String> list = new HashMap<String,String>(); // id - nickname
        for (String str : record){
            String[] splt = str.split(" ");
            if (!splt[0].equals("Change")) n ++ ; // check only 'Change'
            if (!splt[0].equals("Leave")) list.put(splt[1],splt[2]); // check 'Enter'
        }
        String[] answer = new String[n];
        int idx = 0; // answer index
        
        for ( String str : record ){
            String[] splt = str.split(" ");
            if (!splt[0].equals("Change")) {
                if ( splt[0].equals("Enter")) answer[idx] = list.get(splt[1]) + "님이" + " 들어왔습니다.";
                else answer[idx] = list.get(splt[1]) + "님이" + " 나갔습니다.";
                idx++;
                
            }
        }                                      
        return answer;
    }
}
