// n x n 의 체스판에 n 개의 퀸을 배치하려면 각 row에 하나씩 배치해야함.
// 퀸 하나를 배치할때마다 해당 좌표의 세로,가로,대각선을 탐색해 배치 가능한지 확인하기
// 다음 row로 넘어가서 반복
// -> BFS 방식으로 하나씩 배치해보며 가능한 경우만 남겨 cnt 추가

type Chess struct{
    board [][]int
    size int
    cnt int
}
func solution(n int) int {
    c := new(Chess)
    c.size = n
    c.init()
    c.solveQueen(0)
    return c.cnt
}
func (c *Chess)solveQueen(row int){
    if row >= c.size {
        c.countPossibleArrangement()
        return
    }
    for i := 0 ; i < c.size ; i ++ {
        if c.isSafe(row, i){
            c.setQueen(row,i)
            c.solveQueen(row+1)
            c.delQueen(row,i)
        }
    }
}
func (c *Chess)setQueen(row,col int){
    c.board[row][col] = 1
}
func (c *Chess)delQueen(row,col int){
    c.board[row][col] = 0
}
func (c *Chess)isSafe(row int, col int) bool {
    n := c.size
    for i := 0 ; i < n ; i ++ {
        if c.board[i][col] == 1 {
            return false
        } 
    }
    for i,j := row, col ; i >=0 && j >= 0 ; i, j = i-1, j-1 {
        if c.board[i][j] == 1 {
            return false
        } 
    }
    for i,j := row, col ; i >=0 && j < n ; i, j = i-1, j+1 {
        if c.board[i][j] == 1 {
            return false
        } 
    }
    return true
}
func (c *Chess)countPossibleArrangement(){
    c.cnt ++
}
func (c *Chess)init() {
    n := c.size
    board := make([][]int, n)
    for i := 0 ; i < n ; i ++ {
        board[i] = make([]int, n)
    }
    c.board = board
}
