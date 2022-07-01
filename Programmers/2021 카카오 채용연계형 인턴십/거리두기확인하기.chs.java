class Solution {
    static int[][] converted = new int[5][5];
    static int[] answer= new int[5];
    static int[] drow = {-1,1,0,0};
    static int[] dcol = {0,0,-1,1};
    static boolean[][] visited;
    public int[] solution(String[][] places) {
        for (int i = 0 ; i < 5 ; i ++) {
            answer[i] = 1; // 1�� �ʱ�ȭ
            convert(places[i]); // int[5][5] �� ��ȯ
            check(i, converted); // i��° ���ǿ� ���� �Ÿ��α⸦ ��Ű���� Ȯ��
        }
        return answer;
    }
    
    public void check(int order, int[][] place){
        for ( int i = 0 ; i < 5 ; i ++ ){
            for ( int j = 0 ; j < 5 ; j ++){
                if(place[i][j] == 1) { // ����� �ɾ��ִ� ���� dfs call
                    visited = new boolean[5][5]; // backtracking
                    dfs(0,order, i,j);
                }
            }
        }
    }
    public void dfs(int depth,int order, int row, int col){
        if (depth > 0 && depth <= 2 && converted[row][col] == 1) { // 2ĭ ���� ����ڰ� ������ answer 0 ���� üũ �� ����
            answer[order] = 0;
            return;
        }
        if (converted[row][col] == -1 || depth == 2) return; // ĭ���̰� �ְų� 2ĭ���� Ž���� ������ ����
        
        visited[row][col] = true; // �湮 ó��
        
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
