var visit []bool
var answer int
var tg int
var nums []int

func solution(numbers []int, target int) int {
    answer = 0
    tg = target
    nums = numbers
    visit = make([]bool, len(numbers))
    dfs(0,-1) // 시작 숫자가 0이므로 depth도 -1부터 
    return answer
}

func dfs(value int,depth int) {
    if (depth == len(visit) -1 ){
        if (value == tg) {
            answer++          // 모든 숫자를 사용해 target넘버와 같을 때
        }
    }else {
        dfs(value+nums[depth+1], depth+1)  // +
        dfs(value-nums[depth+1], depth+1)  // -
    }
}
