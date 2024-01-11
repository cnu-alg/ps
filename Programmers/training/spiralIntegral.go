package main

import (
	"reflect"
	"fmt"
	)
func main(){
	given := 4
	answer := [][]int{ {1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}
	fmt.Println(reflect.DeepEqual(solution(given),answer))
}


func solution(n int) [][]int {
	res := make([][]int, n)
	for i := range res {
		res[i] = make([]int, n)
	}
	dirs := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}

	row, col, dirIdx := 0, 0, 0

	num := 1
	for num <= n*n {
		res[row][col] = num
		nextRow, nextCol := row+dirs[dirIdx][0], col+dirs[dirIdx][1]
		if nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] != 0 {
			dirIdx = (dirIdx + 1) % 4
		}
		row += dirs[dirIdx][0]
		col += dirs[dirIdx][1]
		num++
	}

	return res
}
