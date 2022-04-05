func solution(n int, lost []int, reserve []int) int {
    uniforms := make([]int, n, n)
	answer := 0

	for i, _ := range uniforms {
		uniforms[i] = 1
	}
	for _, index := range lost {
		uniforms[index-1]--
    }
	for _, index := range reserve {
		uniforms[index-1]++
	}
	
	for i := 0; i < n; i++ {
		if i > 0 && uniforms[i] == 0 && uniforms[i-1] > 1 {
			uniforms[i]++
			uniforms[i-1]--
		}
		if i < n-1 && uniforms[i] == 0 && uniforms[i+1] > 1 {
			uniforms[i]++
			uniforms[i+1]--
		}
	}
	for _, value := range uniforms {
		if value > 0 {
			answer++
		}
	}
	return answer
}
