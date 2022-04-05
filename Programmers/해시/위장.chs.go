func solution(clothes [][]string) int {
    category := make(map[string]int, 0)
    for _, item := range(clothes) {
        category[item[1]] ++
    }
    sum := 1
    for _, num := range(category){
        sum *= num+1
    }
    return sum-1
}
