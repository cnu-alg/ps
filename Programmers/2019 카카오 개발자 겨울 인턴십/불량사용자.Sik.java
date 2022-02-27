import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;

class Solution {
    HashSet<HashSet<String>> answer;
    ArrayList<ArrayList<String>> bannedList;
    HashSet<String> idList = new HashSet<String>();

    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<HashSet<String>>();
        bannedList = new ArrayList<ArrayList<String>>();

        for (String bannedid : banned_id) {

            String pattern = bannedid.replace('*', '.');

            ArrayList<String> valueList = new ArrayList<>();

            for (String userId : user_id) {
                boolean pattern_match = Pattern.matches(pattern, userId);

                if (pattern_match)
                    valueList.add(userId);
            }
            bannedList.add(valueList);
        }

        dfs(idList, 0);

        return answer.size();
    }

    void dfs(HashSet<String> idList, int depth) {
        if (depth == bannedList.size()) {
            answer.add(new HashSet<>(idList));
            return;
        }

        for (String userid : bannedList.get(depth)) {
            if (!idList.contains(userid)) {
                idList.add(userid);
                dfs(idList, depth + 1);
                idList.remove(userid);
            }
        }
    }
}