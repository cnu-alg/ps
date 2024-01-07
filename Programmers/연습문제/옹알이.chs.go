import "strings"

func solution(babbling []string) int {
    cnt := 0
    for i := 0 ; i < len(babbling) ; i ++ {
        if isPossible(babbling[i]) {
        	cnt ++
    	}
    }
    return cnt
}

func isPossible(word string) bool {
    possiblePron := []string{"aya", "ye" , "woo" , "ma"}
    for i := 0 ; i < len(possiblePron) ; i ++ {        
        for strings.Index(word, possiblePron[i]) != -1 {
            word = strings.Replace(word, possiblePron[i], "*", -1)
        }
    }
    word = strings.Replace(word, "*", "", -1)
    if len(word) > 0 {
        return false
    }
    return true
}
