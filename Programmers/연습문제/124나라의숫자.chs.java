class Solution {
    public String solution(int n) {
        String answer = "";
        // 0,1,2로 숫자를 표시하는 3진법과 비슷한 맥락
        while(n>0){
            if (n % 3 == 0){
                answer = "4" + answer;
                n--; // 자리수 변경
            }
            else answer = Integer.toString(n%3) + answer;
            n /=3;
        }
        
        return answer;
    }
}
