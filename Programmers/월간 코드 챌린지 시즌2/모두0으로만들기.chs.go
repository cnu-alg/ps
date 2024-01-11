import "math"

var graph [][]int
var node []int64
var count int64 = 0

func initDS(a []int, edges [][]int){
    graph = make([][]int, len(a))
    node = make([]int64, len(a))
    for i:= 0 ; i < len(a) ; i++ {
        node[i] = int64(a[i])
    }
    for i:= 0 ; i < len(graph); i ++ {
        graph[i] = make([]int, 0)
    }
    for _, edge := range(edges) {
        from := edge[0]
        to := edge[1]
        graph[from] = append(graph[from], to)
        graph[to] = append(graph[to], from)
    }
}

func dfsCleaningTree(idx , parent int){
    for _, child := range(graph[idx]){
        if child != parent {
            dfsCleaningTree(child, idx)
        }
    }
    node[parent] += node[idx]
    count += int64(math.Abs(float64(node[idx])))
}

func solution(a []int, edges [][]int) int64 {
    initDS(a, edges)
    dfsCleaningTree(0, 0)
    
    if node[0] != 0 {
        return -1
    }
    return count
}


