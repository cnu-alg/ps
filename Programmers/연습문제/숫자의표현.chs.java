class Main{
  public static void main(String[] args){
    Solution sol = new Solution();
    System.out.println(4 == sol.solution(15));
  }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i += 2) {
            if (n % i == 0) answer++;
        }
        return answer;
    }
}
