import java.util.Scanner;

public class boj_1937 {
    static int N;
    static Scanner sc = new Scanner(System.in);
    static int[][] map = new int[501][501];
    static int[][] dp = new int[501][501];
    static int[] xRange = {-1, 1, 0, 0};// 상하좌우
    static int[] yRange = {0, 0, -1, 1};// 상하좌우

    public static int ans(int x, int y) {
        if (dp[x][y] == 0) {
            dp[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                int moveX = x + xRange[i];
                int moveY = y + yRange[i];
                if ((1 <= moveX) && (moveX <= N) && (1 <= moveY) && (moveY <= N) && (map[x][y] < map[moveX][moveY])) {
                    dp[x][y] = Math.max(dp[x][y], ans(moveX, moveY) + 1);
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int max = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                max = Math.max(max, ans(i, j));
            }
        }
        System.out.println(max);


    }
}
