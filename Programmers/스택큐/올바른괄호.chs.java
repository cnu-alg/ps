import java.util.Stack;
class Main{
  public static void main(String[] args){
    Solution sol = new Solution();
    System.out.println( true == sol.solution("()()"));
  }
}
class Solution {
    boolean solution(String s) {
        Stack<Integer> st = new Stack<>();
        for ( int i = 0 ; i < s.length() ; i ++){
            if ( s.charAt(i) == '(') st.push(0);
            else {
                if ( st.isEmpty()) return false;
                if ( st.pop() != 0) return false;
            }
        }
        return (st.isEmpty())? true: false;
    }
}
