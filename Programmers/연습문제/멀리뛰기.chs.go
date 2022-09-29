func solution(n int) int64 {
    dp := make([]int64, 0)
    init := []int64{0,1,2}
    dp = append(dp, init...)
    
    for i:= 3 ; i <= n ; i ++ {
        dp = append(dp, (dp[i-2] + dp[i-1]) % 1234567)
    }
    
    return dp[n]
}
