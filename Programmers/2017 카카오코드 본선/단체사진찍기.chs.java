class Solution {
    static int answer;
    static boolean visit[] = new boolean[8];
    static char entry[] = {'A','C','F','J','M','N','R','T'};
    static void dfs(int depth, String batch,String[] data){
        if ( depth == 8 ) {
            if (isPossible(batch, data)){
                answer++;
            }
            return;
        }
        for ( int i = 0 ; i < 8 ; i ++ ){
            if(visit[i]) continue;
            visit[i] = true;
            batch += entry[i];
            dfs(depth+1, batch, data);
            visit[i] = false;
            batch = batch.substring(0, batch.length() - 1);
        }
        
    }

    static boolean isPossible(String batch, String[] data){
        for(int i = 0 ; i<data.length;i++){
            // 사이 간격이므로 - 1
            int distance = Math.abs(batch.indexOf(String.valueOf(data[i].charAt(0))) - batch.indexOf(String.valueOf(data[i].charAt(2))))-1;
            // " - '0' "으로 정수 값 변환
            int condition = data[i].charAt(4) - '0';
                        
            // 조건 분기
            switch(data[i].charAt(3)){
                // 조건 불충분 시 false
                case '=' :
                    if(distance != condition) return false;
                    break;
                    
                case '>' :
                    if(distance <= condition) return false;
                    break;
                    
                case '<':
                    if(distance >= condition) return false;
                    break;                    
            }
            
        }
        
        // 통과 시 true.
        return true;
    }
    public int solution(int n, String[] data) {
        String batch = "";
        answer = 0;
        dfs(0, batch, data);
        return answer;
    }
}

/*
1. 8명을 모두 배치하는 경우의 수를 완전 탐색을 통해 찾는다.
2. 8명을 모두 배치했을 때 주어진 조건에 맞는 지 확인한다.
3. 조건을 만족하면 +1 해줌

    main flow{
        dfsSearch() -> isPossible() -> +1 or return
    }

*/
