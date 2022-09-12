class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] memory = new int[n][m];
        for ( int[] puddle : puddles) memory[puddle[1]-1][puddle[0]-1] = -1;
        
        memory[0][0] = 1;
        
        for ( int i = 0 ; i < n ; i ++){
            for ( int j = 0 ; j < m ; j ++ ){
                
                if ( memory[i][j] == -1 ){
                    memory[i][j] = 0 ;
                    continue;
                }
                if (!( i == 0 && j == 0)){
                    int way1 = 0;
                    int way2 = 0;
                    if(i > 0) way1 = memory[i-1][j];
                    if(j > 0) way2 = memory[i][j-1];
                    memory[i][j] = ( way1 + way2 ) % 1000000007;
                }
                
                
            }
        }
        
        return memory[n-1][m-1];
    }
}
