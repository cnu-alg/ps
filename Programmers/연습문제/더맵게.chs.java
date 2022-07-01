import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // Min 우선순위
        for (int scov : scoville) priorityQueue.add(scov); // scoville 추가
        int answer = 0;
        
        while(true){
            if(priorityQueue.size() == 1 && priorityQueue.peek() < K) return -1; // 1개 남았고 스코빌이 K보다 작다면 조건 불만족이므로 -1 Return
            if(! (priorityQueue.peek() < K)) break; // 최소 스코빌이 K 이상이면 escape loop
            priorityQueue.add(priorityQueue.poll() + 2*priorityQueue.poll()); // 주어진 조건대로 스코빌을 섞어 새로운 값을 넣음
            answer++;
        }
        
        return answer;
    }
}
