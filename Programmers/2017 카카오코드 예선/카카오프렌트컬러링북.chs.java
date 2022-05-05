class Solution {
    static int[][] board;
    static int area;
    // 상 하 좌 우
    
    public int[] solution(int m, int n, int[][] picture) {
        area = 0;
        board = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = picture[i][j];
            }
        }

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        // picture를 순회하며 0이 아니면 dfs 함수 호출
        for(int row = 0 ; row < m ; row++){
            for (int col = 0 ; col < n ; col++){
                if ( board[row][col] > 0 ) {
                    // dfs 함수로 영역의 넓이를 구하고 maxSizeofOneArea 값을 업데이트
                    dfsArea(board[row][col],row,col,m,n);
                    if ( area > maxSizeOfOneArea) maxSizeOfOneArea = area;
                    area = 0; // 영역 넓이 0으로 초기화
                    numberOfArea ++;
                }
                // printPicture();
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
    void dfsArea(int value, int row, int col, int rowMax, int colMax){
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,-1,1};
        area++; // 영역 넓이 + 1
        board[row][col] = 0;
        for ( int i = 0 ; i < 4 ; i ++){
            int moveRow = row+dy[i];
            int moveCol = col+dx[i];
            
            if (moveRow < rowMax && moveRow >= 0 && moveCol >= 0 &&moveCol < colMax && board[moveRow][moveCol] == value ) {// 인덱스 검사 && 색깔 비교
                dfsArea(value, moveRow,moveCol, rowMax,colMax);
            }
        }
    }
    void printPicture(){
        for (int[] row : board){
            for (int col : row){
                System.out.print(col+ " ");
            }
            System.out.println();
        }
        System.out.println();        
    }
}
