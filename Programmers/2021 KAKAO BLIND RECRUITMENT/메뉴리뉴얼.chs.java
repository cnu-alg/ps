import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static Map<String, Integer> map;
    static boolean[] visit;
    static String[] orderlist;

    void dfs(int depth, int len, int order, int last, String menu){
        if (depth == len) {
            map.put(menu, map.getOrDefault(menu,0)+1);
            return;
        }
        
        for ( int i = last ; i < orderlist[order].length(); i ++ ){
            if(visit[i]) continue;
            visit[i] = true;
            dfs(depth+1, len, order, i, menu+orderlist[order].charAt(i));
            visit[i] = false;
        }
        
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        ArrayList<String> answer = new ArrayList<String>(); 
        orderlist = new String[orders.length];
        
        for ( int i = 0 ; i < orders.length; i ++){ // 사전순 정렬하여 전역변수에 할당
            char[] charArr = orders[i].toCharArray(); 
            Arrays.sort(charArr);
            orderlist[i] = new String(charArr);
        }
        
        for(int len : course){
            ArrayList<String> list = new ArrayList<String>(); 
            map = new HashMap<String, Integer>();
            
            // step1. 코스 크기별로 가능한 조합의 주문 횟수를 map에 저장
            for (int i = 0 ; i < orderlist.length; i ++){ 
                visit = new boolean[orderlist[i].length()];
                if (orderlist[i].length() >= len) dfs(0,len, i,0, "");
            }
            // step2. map에 저장된 주문 중에서 주문 횟수가 많은 메뉴 선택
            
            int max = 2;
            for (Entry<String, Integer> entrySet : map.entrySet()) {
                if ( entrySet.getValue() > max ){
                    max = entrySet.getValue();
                    list = new ArrayList<String>();
                }
                if ( entrySet.getValue() == max ) {
                    list.add(entrySet.getKey());
                }
            }
            // step3. answer에 list 전체 추가
            answer.addAll(list);
        }
        
        // step4. 저장된 메뉴를 사전순으로 정렬
        Collections.sort(answer);
        
        // hashmap[메뉴구성] = 개수 로 저장?
        //     -> 그럼 개수 별로 가장 많은 코스요리 추출은 어떻게?,,,
        //           -> map key-value 추출해서 key 길이로 하면 될 듯
        // 각 손님 별로 cource( 2 ~ n )개의 메뉴 구성을 완전 탐색한다.
        
        
        
        return answer.toArray(new String[0]);
    }
}
