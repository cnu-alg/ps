// import "fmt"
func solution(rows, columns int, queries [][]int) []int {
	matrix := make([][]int, rows)
	for i := 0; i < rows; i++ {
		matrix[i] = make([]int, columns)
		for j := 0; j < columns; j++ {
			matrix[i][j] = i*columns + j + 1
		}
	}

	var answer []int

	for _, q := range queries {
		x1, y1, x2, y2 := q[0]-1, q[1]-1, q[2]-1, q[3]-1

		tmp := matrix[x1][y1]
		minTmp := tmp

		x, y := x1, y1

		for x < x2 {
			matrix[x][y] = matrix[x+1][y]
			minTmp = min(minTmp, matrix[x][y])
			x++
		}

		for y < y2 {
			matrix[x][y] = matrix[x][y+1]
			minTmp = min(minTmp, matrix[x][y])
			y++
		}

		for x1 < x {
			matrix[x][y] = matrix[x-1][y]
			minTmp = min(minTmp, matrix[x][y])
			x--
		}

		for y1 < y {
			if y == y1+1 {
				matrix[x][y] = tmp
			} else {
				matrix[x][y] = matrix[x][y-1]
			}
			minTmp = min(minTmp, matrix[x][y])
			y--
		}

		answer = append(answer, minTmp)
	}

	return answer
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
