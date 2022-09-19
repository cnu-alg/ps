class Main{
  public static void main(String[] args){
    Solution sol = new Solution();
    int[] answer = {4,3};
    int[] test = sol.solution(10,2);
    if ( test[0] == answer[0] && test[1] == answer[1]) System.out.println("True");
    else System.out.println("False");
  }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for (int i = 3; i < sum; i++) {
            int j = sum / i;
            if (sum % i == 0) {
                if ((i - 2) * (j - 2) == yellow) {
                    answer = ( i > j ) ? new int[]{i,j} : new int[]{j,i};
                    return answer;
                }
            }
        }
        return answer;
    }
}
