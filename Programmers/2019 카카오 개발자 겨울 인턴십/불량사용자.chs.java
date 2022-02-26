import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
class Solution {
    
    // step 1. field 선언
    static ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
    static Set<Set<String>> answer_set = new HashSet<Set<String>>();
    
    public int solution(String[] user_id, String[] banned_id) {    
        
        // step 2. 경우의 수 체크
        for ( int i = 0 ; i < banned_id.length ; i ++ ){
            list.add(ban_check(user_id, banned_id[i]));
        }
        
        // step 3. 제재 리스트 중복 체크
        // 2단계에서 구한 경우의 수로 완전 탐색을 통해 중복 없는 가능한 경우의 수 계산
        dfs(new HashSet<String>(), 0);
        
        // step 4. 제재 리스트 크기 반환
        return answer_set.size();
    }
    
    ArrayList<String> ban_check(String[] ids, String ban_id){
        String pattern = ban_id.replace('*', '.'); // 정규표현식 매칭에서 . 은 모든 문자에 통과
      	ArrayList<String> banList = new ArrayList<>();
        
        for (String id : ids) {
            boolean isMatch = Pattern.matches(pattern, id);

          // 제재 대상자 리스트에 추가
            if (isMatch) banList.add(id);
        }
      
      	return banList;
    }
    
    void dfs(HashSet<String> add2ban, int depth) {
        if (depth == list.size()) {
            answer_set.add(new HashSet<>(add2ban));
            return;
        }
      	
        for (String userId : list.get(depth)) {
            if (!add2ban.contains(userId)) {
                add2ban.add(userId);
                dfs(add2ban, depth + 1);
                add2ban.remove(userId);
            }
        }
    }
}
