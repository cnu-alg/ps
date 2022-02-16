import java.util.ArrayList;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int crane = 0;
        int size1 = 0;
        int size2 = 0;

        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < moves.length; i++ ){
            crane = moves[i];
            for(int j = 0; j < board.length; j++){
                if (board[j][crane-1] != 0){
                    result.add(board[j][crane-1]);
                    board[j][crane-1] = 0;
                    size1++;
                    break;
                }
            }
            if (result.size() != 0){
                for(int k = 0; k < result.size() - 1; k++){
                    if (result.get(k) == result.get(k+1)){
                        result.remove(k);
                        result.remove(k);
                    }
                }
            }
        }
        size2 = result.size();

        answer = size1 - size2;
        return answer;
    }
}