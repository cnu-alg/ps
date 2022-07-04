import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // Min �켱����
        for (int scov : scoville) priorityQueue.add(scov); // scoville �߰�
        int answer = 0;
        
        while(true){
            if(priorityQueue.size() == 1 && priorityQueue.peek() < K) return -1; // 1�� ���Ұ� ���ں��� K���� �۴ٸ� ���� �Ҹ����̹Ƿ� -1 Return
            if(! (priorityQueue.peek() < K)) break; // �ּ� ���ں��� K �̻��̸� escape loop
            priorityQueue.add(priorityQueue.poll() + 2*priorityQueue.poll()); // �־��� ���Ǵ�� ���ں��� ���� ���ο� ���� ����
            answer++;
        }
        
        return answer;
    }
}
