var moves [][]int

func solution(n int) [][]int {
    hanoi(n,1,2,3)
    return moves
}
func move(src,dst int){
    moves = append(moves, []int{src,dst})
}
func hanoi(n, src, via, dst int){
    // 원판이 한개라면 옮기고 끝
    if n == 1 {
        move(src,dst)
        return
    }
    // hanoi는 크게 3가지 과정으로 나뉜다.
    // 1. 맨 아래 가장 큰 원반을 옮기기 전 나머지 n-1개를 경유축으로 옮기는 과정
    hanoi(n-1, src, dst, via)
    // 2. 맨 아래 가장 큰 원반을 목적축으로 옮기는 과정
    move(src,dst)
    // 3. 경유축에 옮겨진 n-1개의 원반을 목적축으로 옮기는 과정
    hanoi(n-1, via, src, dst)
}
