class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;
        for (int i = 0 ; i < grid.length; i ++ ){
            for (int j = 0 ; j < grid[i].length ; j ++){
                if ( grid[i][j] == '1' ){
                    answer ++;
                    dfs(grid,i,j);
                }
            }
        }
        return answer;
    }
    public void dfs(char[][] grid, int x, int y){
        grid[x][y] = '2'; // 방문표시
        int maxX = grid.length;
        int maxY = grid[0].length;
        int[] dx = {-1,0,0,1}; // 상 하 
        int[] dy = {0,1,-1,0}; // 좌 우 
        for ( int i = 0 ; i < 4 ; i ++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if ( newX > -1 && newX < maxX && newY > -1 && newY <maxY && grid[newX][newY] == '1') dfs(grid, newX,newY);
        }
    }
}
