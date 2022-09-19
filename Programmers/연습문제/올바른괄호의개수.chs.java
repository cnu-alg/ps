class Main{
  public static void main(String[] args){
    Solution sol = new Solution();
    int test = 3;
    System.out.println(sol.solution(test) == 5);
  }
}
class Solution {
    int count;
    public int solution(int n) {
        count = 0;
        dfs(0,0,n);
        return count;
    }
    void dfs(int left, int right, int n){
        if ( left < right || left > n || right > n) return;
        if ( left + right == 2*n){
            count ++;
            return;
        }
        dfs(left+1, right, n);
        dfs(left, right+1, n);
    }
}
