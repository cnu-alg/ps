package main

import (
	"strconv"
	"fmt"
	"strings"
	"bufio"
	"os"
)

var kit int
var loss int
var count int
var kitEff []int
var visit []bool
func main(){
	count = 0

	reader := bufio.NewScanner(os.Stdin)	
	visit = make([]bool,kit)
	fmt.Scanf("%d %d", &kit, &loss)
	reader.Scan() 
	slice := strings.Split(reader.Text(), " ")
	for _, str := range slice {
		eff,_ :=strconv.Atoi(str)
		kitEff = append(kitEff, eff - loss ) 
		visit = append(visit, false)
	}
	backTracking(500, 0)
	fmt.Println(count)
}

func backTracking(currW int, depth int){
	if depth == kit-1 {
		count ++
	}
	for i := 0 ; i < len(visit); i ++ {
		if !visit[i] {
			visit[i] = true
			if currW+kitEff[i] >= 500 {
				backTracking(currW + kitEff[i], depth+1)
				visit[i] = false
			} else { visit[i] = false}
  
		}
	}
	
}
