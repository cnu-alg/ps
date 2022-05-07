class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 번호 i 와 번호 j 의 거리 차이는
        // ( i - j ) 를 3으로 나눈 몫과 나머지의 합이다.
        // = ( i - j ) / 3 + ( i - j ) % 3
        int leftidx = 10;
        int rightidx = 12;
        for ( int n : numbers ) { // 1, 4, 7
            if ( n % 3 ==  1) {
                answer += "L";
                leftidx = n;
            } else if ( n != 0 && n % 3 == 0 ){ // 3, 6, 9
                answer += "R";
                rightidx = n;
            } else { // 2, 5 ,8 ,0 인 경우
                int lefthand = distance(leftidx, n);
                int righthand = distance(rightidx, n);
                if ( lefthand == righthand ){
                    if (hand.equals("right")) {
                        answer +="R";
                        rightidx = n;
                    }else{
                        answer +="L";
                        leftidx = n;
                    }
                } else if ( lefthand < righthand ) {
                    answer += "L";
                    leftidx = n;
                }
                else {
                    answer+="R";
                    rightidx = n;
                }
            }
        }
        
        return answer;
    }
    int distance(int i, int j){
        if ( i == 0 ) i = 11;
        if ( j == 0 ) j = 11;
        return  Math.abs((i-j)/3 + (i-j)%3); 
    }
}
