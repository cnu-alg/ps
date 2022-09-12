import java.util.PriorityQueue;
import java.util.Collections;
class Main{
  public static void main(String[] args){
    int[] works1 = {4,3,3,13,4,3,2,1321,442,32,1,2,2,2,1,2,2};
    int[] works2 = {4,3,3};
    Solution sol = new Solution();
    System.out.println(sol.solution(4, works2));

  }
}
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for ( int work : works){
          q.add(work);
        }
        while(!q.isEmpty() && n > 0){
          int value = q.poll();
          if ( --value > 0 ) q.add(value);
          n--;
        }
        while(!q.isEmpty()){
          answer += Math.pow(q.poll(),2);
        }
        return answer;
    }
}
