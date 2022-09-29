import java.util.Arrays;

class Main{
  public static void main(String[] args){
    Solution sol = new Solution();
    int[] testcase = {2,14,11,21,17};
    int result = 4;
    System.out.println( result == sol.solution(25,testcase,2));
  }
}
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return binerySearch(distance, rocks, n);
    }

    int binerySearch(int distance, int[] rocks, int n){
        long ans = 0;
        long left = 1, right = distance, mid = 0;

        while(left <= right){
            int cnt = 0;
            int prev = 0;
            mid = (left + right) / 2;

            for(int i = 0 ; i < rocks.length ; ++i){
                if(rocks[i] - prev < mid){
                    cnt++;
                } else {
                    prev = rocks[i];
                }
            }

            if(distance - prev < mid) cnt++;

            if(cnt <= n){
                ans = mid > ans ? mid : ans;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }
}
