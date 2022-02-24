import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드 알고리즘 사용
// 플로이드 문제
// 모든 정점을 출발점으로 하여 모든 정점을 목적지로 했을 때의 최단경로를 구하는 알고리즘
public class Main {
	static int[][] map;
	static final int MAX_VALUE = 10000001;
	
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int m = Integer.valueOf(st.nextToken());
			map = new int[n][n];	// 이제 모든 인덱스에서 -1 해주기

			for(int i = 0; i < n; i++) {
				Arrays.fill(map[i], MAX_VALUE);	
				map[i][i] = 0;
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.valueOf(st.nextToken()) - 1;	// 0부터 시작
				int end = Integer.valueOf(st.nextToken()) - 1;	// 0부터 시작
				int weight = Integer.valueOf(st.nextToken());
				if(map[start][end] > weight) {
					map[start][end] = weight;	
				}
			}
			
			floyd(n);
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == MAX_VALUE) {
						map[i][j] = 0;
					}
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
		}
		catch (NumberFormatException e) {
			System.exit(0);
		}
		catch (IOException e) {
			System.exit(0);
		}
	}
	
	// 플로이드 알고리즘
	public static void floyd(int n) {
		for(int k = 0; k < n; k++) { // 경유 지점 
			for(int i = 0; i < n; i++) { // 출발 지점
				if(k == i) {
					continue;
				}
				for(int j = 0; j < n; j++) { // 도착 지점 
					if(i != j && i != j) {
						if(map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}
		}
	}
}

