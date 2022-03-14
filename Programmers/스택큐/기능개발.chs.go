func solution(progresses []int, speeds []int) []int {
    
    max,count:= 0,0;
    result := []int{};
    for idx, current := range progresses {
        remain := 100 - current;
        require := remain/speeds[idx];
        if ( remain % speeds[idx] != 0 ) {
            require++;
        }
        if ( max < require ) {
            result = append(result, count);
            count = 1;
            max = require;
        } else {
            count ++;
        }
    }
    result = append(result[:0], result[1:]... );
    return append(result,count);
    
}
