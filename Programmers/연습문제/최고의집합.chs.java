class Main{
  public static void main(String[] args){
    Solution sol = new Solution();
    int test_n = 5;
    int test_s = 11;
    int[] result = new int[]{2,2,2,2,3};
    int[] answer = sol.solution(test_n, test_s);
    for ( int i = 0 ; i < 5 ; i ++ ){
      if ( answer[i] != result[i] ) {
        System.out.println("FALSE");
        return;
      }
    }
    System.out.println("TRUE");
  }
}
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if ( n > s ) return new int[]{-1}; // exception
        
        for ( int i = 0 ; i < n ; i ++ ){
            int fit = s/(n-i);
            answer[i] = fit;
            s -= fit;
        }
        return answer;
    }
}
