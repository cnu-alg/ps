class Solution {
    static int[][] converted = new int[5][5];
    static int[] answer= new int[5];
    static int[] drow = {-1,1,0,0};
    static int[] dcol = {0,0,-1,1};
    static boolean[][] visited;
    public int[] solution(String[][] places) {
        for (int i = 0 ; i < 5 ; i ++) {
            answer[i] = 1; // 1로 초기화
            convert(places[i]); // int[5][5] 로 변환
            check(i, converted); // i번째 대기실에 대해 거리두기를 지키는지 확인
        }
        return answer;
    }
    
    public void check(int order, int[][] place){
        for ( int i = 0 ; i < 5 ; i ++ ){
            for ( int j = 0 ; j < 5 ; j ++){
                if(place[i][j] == 1) { // 사람이 앉아있는 곳만 dfs call
                    visited = new boolean[5][5]; // backtracking
                    dfs(0,order, i,j);
                }
            }
        }
    }
    public void dfs(int depth,int order, int row, int col){
        if (depth > 0 && depth <= 2 && converted[row][col] == 1) { // 2칸 내에 사용자가 있으면 answer 0 으로 체크 후 종료
            answer[order] = 0;
            return;
        }
        if (converted[row][col] == -1 || depth == 2) return; // 칸막이가 있거나 2칸까지 탐색을 했으면 종료
        
        visited[row][col] = true; // 방문 처리
        
        for (int i = 0 ; i < 4 ; i ++){
            int newRow = row + drow[i];
            int newCol = col + dcol[i];
            if ( newRow >= 0 && newRow < 5 && newCol >=0 && newCol < 5){
                if (!visited[newRow][newCol]) dfs(depth+1, order, newRow, newCol);
            }
        }    
    }
    
    public void convert(String[] status){
        for (int i = 0 ; i < 5 ; i ++){
            for(int j = 0 ; j < 5 ;j ++){
                char stat = status[i].charAt(j);
                // P -> 1
                // O -> 0
                // X -> -1
                converted[i][j] = (stat=='P') ? 1 : (stat=='O') ? 0 : -1;
            }
        }
    }
}
