import (
    "sort"
)

type song struct {
    id int
    g string
    plays int
    rank int
}
func solution(genres []string, plays []int) []int {
    sumMap := make(map[string]int) // 장르별 재생횟수를 누적할 Map
    checkMap := make(map[string]int) // 장르별 수록곡 개수를 카운트할 Map
    newSongs := make([]song, 0) // 주어진 입력을 song type으로 재정의한 후 사용할 slice
    
    // genres와 plays를 이용해 장르별 재생횟수를 카운트하고, 타입 {고유번호, 장르, 재생횟수}으로 새롭게 생성후 newSongs에 저장
    for idx , gen := range genres {
        sumMap[gen] += plays[idx]
        newSongs = append(newSongs, song{id:idx,g:gen,plays:plays[idx]})
    }
    
    // 장르별 재생횟수를 카운트한 sumMap을 사용하여 장르 순위를 정렬
    genRank := make([]string, 0, len(sumMap))
    for gen, _ := range sumMap {
        genRank = append(genRank, gen) 
    }
    sort.Slice(genRank, func(i, j int) bool {
        return sumMap[genRank[i]] > sumMap[genRank[j]]
    })

    // 정렬된 장르 순위에 맞춰 newSongs의 곡들의 순위도 정해준다.
    for i:= 0 ; i< len(newSongs) ; i ++ {
        for idx, gen := range genRank {
            if (newSongs[i].g == gen) {
                newSongs[i].rank = idx
            }
        }
    }
    
    sortedSongs:= make([]song, 0, len(newSongs)) // 조건을 만족하여 정렬된 곡들을 담을 스라이스
    
    // 장르 순위별로 정렬한다.
    for _ , gen := range genRank{
        genPlays:= make([]song,0) // 장르별로 수집할 슬라이스
        for i:=0 ; i < len(newSongs) ; i ++ {
            if (gen == newSongs[i].g) {
                genPlays = append(genPlays,newSongs[i])
            }
        }
        // 장르별 수집 끝 , 재생횟수별로 정렬 시작
        sort.Slice(genPlays, func(i,j int) bool {
            // 위에서 순서대로 곡을 담았기때문에 재생횟수가 같은 경우 작은 id를 반환하는 조건은 신경쓰지 않아도 된다.
            return genPlays[i].plays > genPlays[j].plays
        })
        sortedSongs = append(sortedSongs, genPlays...)
    }
    
    answer := make([]int,0)
    for _, song := range sortedSongs {
        if (checkMap[song.g] < 2) { // 해당 장르 곡이 2개 미만으로 수록된 경우
            answer = append(answer, song.id) // 해당 곡의 아이디를 answer에 추가
            checkMap[song.g] ++ // 해당 장르 곡 추가 카운트
        }
    }
    return answer
}
