class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        // 영단어:숫자 ( one : 1 ) 로 매핑해놓고 문자열을 검사하며 교체하는 방법
        for ( int i = 0 ; i < nums.length ; i ++){
            s=s.replace(nums[i], Integer.toString(i));
        }
        return Integer.valueOf(s);
    }
}
