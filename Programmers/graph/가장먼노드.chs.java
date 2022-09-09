import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static ArrayList<ArrayList<Integer>> list;
    static int max = 0;
    static boolean[] check;
    public int solution(int n, int[][] edge) {
        list = new ArrayList<>();
        check = new boolean[n+1];
        for ( int i = 0 ; i < n+1 ; i ++) list.add(new ArrayList<>());
        
        for ( int[] vertex: edge){
            list.get(vertex[0]).add(vertex[1]);
            list.get(vertex[1]).add(vertex[0]);
        }
        int answer = 0;
        return bfs();
    }
    int bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        check[1] = true;
        q.offer(1);
        int sum = 0;
        while(true){
            Queue<Integer> temp = new LinkedList<Integer>();
            while(!q.isEmpty()){
                int x = q.poll();
                for ( int i = 0 ; i < list.get(x).size(); i ++){
                   if ( !check[list.get(x).get(i)]) {
                       temp.offer(list.get(x).get(i));
                       check[list.get(x).get(i)] = true;
                   }
                }
            }
            if ( temp.isEmpty()) break;
            q.addAll(temp);
            sum = temp.size();
        }
        return sum;
    }
    
}
