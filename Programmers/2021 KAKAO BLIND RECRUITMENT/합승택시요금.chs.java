import java.util.Arrays;
class Main{
  public static void main(String[] args){
    int[][] test = {{4, 1, 10}, {3, 5, 24},{5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
    Solution sol = new Solution();
    System.out.println(82 == sol.solution(6, 4, 6, 2, test));
  }
}
class Solution {
    int[][] dp;
    int MAX = 200 * 100000 + 1;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        dp = new int[n+1][n+1];
        getFloydTable(n, fares);
        return minFeeIncludeLayover(s,a,b);
    }
    void getFloydTable(int n, int[][] fees){
        // init
        for ( int i = 0 ; i < n+1; i ++){
            Arrays.fill(dp[i] , MAX);
            dp[i][i] = 0;
        }
        // set via given fees
        for ( int i = 0 ; i < fees.length; i ++){
            int start = fees[i][0];
            int end = fees[i][1];
            int fee = fees[i][2];

            dp[start][end] = fee;
            dp[end][start] = fee;
        }
        // Floyd warshall
        for(int k = 1; k < n+1; k++) {
            for(int i = 1; i < n+1; i++) {
                for(int j = 1; j < n+1; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
    }
    int minFeeIncludeLayover(int start, int dst_a, int dst_b){
        int answer = dp[start][dst_a] + dp[start][dst_b];
        // Find best fees compare all layover case;
        for(int i = 1; i < dp.length; i++) {
            answer = Math.min(answer, dp[start][i] + dp[i][dst_a] +dp[i][dst_b]);
        }
        return answer;
    }
}
