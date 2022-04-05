import (
    "math"
)
// 총 광물의 양, 전달 횟수, 적재량을 받아
// 전달할 수 있는 최대 광물의 양을 구하는 함수
func GetMaxMineral(mineral int64 , move_cnt int64 , weight int64) int64 {
    if mineral < move_cnt * weight {
        return mineral
    } else {
        return move_cnt * weight
    }
}
func Min(a int64, b int64) int64 {
    if a<b {
        return a
    }
    return b
}

func solution(a int, b int, g []int, s []int, w []int, t []int) int64 {
    answer := int64(math.Pow(10,9)) * int64(math.Pow(10,5)) * 4
    start := int64(0)
    end := answer
    for start <= end{
        mid := int64((start+end)/2)
        var gold,silver,total int64= 0,0,0
        
        for i:= 0 ; i < len(g) ; i ++ {
            i_gold, i_silver, i_weight, i_time :=int64(g[i]),int64(s[i]),int64(w[i]),int64(t[i])
            mv := mid / (i_time * 2) // 왕복 가능 횟수
            if mid % (i_time*2) >= i_time {
                mv ++
            }
            // 최대로 전달할 수 있는 금, 은, 토탈값을 구한다.
            gold += GetMaxMineral(i_gold, mv, i_weight)
            silver += GetMaxMineral(i_silver,mv,i_weight)
            // 토탈값은 같은 도시에서 금과 은을 모두 운반하는 경우 mv카운트가 겹치기때문에 
            // 체크해야할 조건이다.
            if (i_gold + i_silver < mv * i_weight){
                total += i_gold + i_silver
            } else {
                total += mv * i_weight 
            }
        }   
        // 금과 은이 모두 기준치이상이며 토탈값 또한 만족할 때
        if gold >= int64(a) && silver >= int64(b) && total >= int64(a + b){
            end = mid - 1 // mid~end 를 날림
            answer = Min(answer,mid)
            
        } else { // 만족 X
            start = mid + 1 // start ~ mid 를 날림
        }
    }
    return answer
}
