import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_13549 {
    static int N,K;
    static Scanner sc = new Scanner(System.in);
    static boolean[] visit;
    static final int max = 100001; // visit 0 ~ 100000 까지
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) {
        visit = new boolean[max];
        N = sc.nextInt();
        K = sc.nextInt();
        visit[N] = true;
        Node start = new Node(N,0);
        System.out.println(bfs(start));
    }

    private static int bfs(Node start) {
        // start -1 , start +1 , 2 * start 3개의 자식 노드가 있음.
        if ( start.x == K){return 0;}
        queue.add(start);

        while(!queue.isEmpty()){
            Node n = queue.poll();
//            System.out.println("X : " + n.x + " Sec : " + n.sec);

            // X * 2 를 했을 때 범위 내에 있을 시 visit 체크 & K와 비교 후 Return Or Queue add 결정
            if ( n.x*2 <= max){
                if (!visit[n.x*2]){
                    if ( n.x*2 == K) return n.sec;
                    else {
                        visit[n.x*2] = true;
                        queue.add(new Node(n.x*2,n.sec));
                    }
                }
            }

            // X - 1 를 했을 때 범위 내에 있을 시 visit 체크 & K와 비교 후 Return Or Queue add 결정
            if  (n.x>0){
                if (!visit[n.x-1]){
                    if (n.x-1 == K) return n.sec+1;
                    else {
                        visit[n.x -1] = true;
                        queue.add(new Node(n.x-1,n.sec+1));
                    }
                }
            }

            // X + 1 를 했을 때 범위 내에 있을 시 visit 체크 & K와 비교 후 Return Or Queue add 결정
            if ( n.x < max-1){
                if (!visit[n.x+1]){
                    if (n.x+1 == K) return n.sec+1;
                    else {
                        visit[n.x+1] = true;
                        queue.add(new Node(n.x+1,n.sec+1));
                    }
                }
            }

        }
        return -1;



    }
    static class Node{
        int x;
        int sec;
        Node(int newX, int newSec){
            this.x = newX;
            this.sec = newSec;
        }
    }
}

