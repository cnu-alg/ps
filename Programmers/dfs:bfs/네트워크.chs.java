class Main{
  public static void main(String[] args){
    Solution sol = new Solution();
    int[][] computers1 = {{1,1,0},{1,1,1},{0,1,1}};
    System.out.println(sol.solution(3, computers1));
  }
}
class Solution {
    static int[] network;
    static int[][] cps;
    public int solution(int n, int[][] computers) {
        network = new int[n];
        cps = computers;
        int num = 1;
        // 모든 컴퓨터에 네트워크 번호가 매겨질 때 까지 반복
        for ( int i = 0 ; i < n ; i ++){
            if ( network[i] != 0) continue;
            dfs(i, num);
            num++;
        }
        return num-1;
    }
    void dfs(int i, int num){
        network[i] = num;
        for ( int k = 0 ; k < cps[i].length ; k ++){
            if ( cps[i][k] == 1 && network[k] == 0) dfs(k, num);
        }
    }
}

