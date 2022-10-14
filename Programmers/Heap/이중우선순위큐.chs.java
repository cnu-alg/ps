import java.util.Collections;
import java.util.PriorityQueue;
class Main{
  public static void main(String[] args){
    Solution sol = new Solution();
    String[] test_operations = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
    int[] result = new int[]{0,0};
    int[] answer = sol.solution(test_operations);
    for ( int i = 0 ; i < 2 ; i ++ ) { 
      if ( answer[i] != result[i]) {
        System.out.println("FALSE");
        return;
      }
    }
    System.out.println("TRUE");
  }
}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        for ( String cmd : operations ){
            String[] command = cmd.split(" ");
            int value = Integer.parseInt(command[1]);
            switch ( command[0] ){
                case "I" :
                    minQ.offer(value);
                    maxQ.offer(value);
                    break;
                case "D" :
                    if ( minQ.isEmpty() ) continue;
                    if ( value > 0){
                        int target = maxQ.poll();
                        minQ.remove(target);
                    } else {
                        int target = minQ.poll();
                        maxQ.remove(target);
                    }
                    break;
            }
        }
        answer[0] = (maxQ.isEmpty())? 0 : maxQ.poll();
        answer[1] = (minQ.isEmpty())? 0 : minQ.poll();
        return answer;
    }
}
