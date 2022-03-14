func solution(rows int, columns int, queries [][]int) []int {
    table := [][]int{}
    result := []int{}
    for r:= 0 ; r < rows ; r ++ {
        col := []int{}
        for c := 0 ; c < columns ; c ++ {
            col = append(col,r*columns+c+1)
        }
        table = append(table,col)
    }

    for _,query :=range queries{
        result = append(result,getMin(query, &table))
    }
    return result
}
func getMin(query []int, table *[][]int) (int) {
    r1:=query[0]-1
    c1:=query[1]-1
    r2:=query[2]-1
    c2:=query[3]-1
    temp := (*table)[r1][c1]
    min := temp
    for i:= r1 ; i < c1 ; i ++ {
        (*table)[i][c1] = (*table)[i+1][c1]
        min = Min(min, (*table)[i][c1])
    }
    for i:= c1 ; i < c2 ; i ++ {
        (*table)[r2][i] = (*table)[r2][i+1]
        min = Min(min, (*table)[r2][i])
    }
    for i:= r2 ; i > r1 ; i -- {
        (*table)[i][c2] = (*table)[i-1][c2]
        min = Min(min,(*table)[i][c2])
    }
    for i:= c2 ; i > c1 ; i -- {
        (*table)[r1][i] = (*table)[r1][i-1]
        min = Min(min,(*table)[r1][i])
    }
    (*table)[r1][c1+1] = temp
    return min
}
func Min(a,b int) int{
    if a<b {
        return a;
    }
    return b;
}
