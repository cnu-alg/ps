
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static final int MAX_X = 100000;
    public static Queue<FinderInfo> queue = new LinkedList<>();
    public static boolean[] visited = new boolean[MAX_X + 1];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.print(bfs(new FinderInfo(N, 0), K));

        sc.close();
    }

    static int bfs(FinderInfo finderInfo, int targetX) {

        if (finderInfo.x == targetX)
            return 0;

        queue.add(finderInfo);

        while (!queue.isEmpty()) {
            FinderInfo current = queue.poll();

            if (current.x == targetX)
                return current.sec;

            move(current.x * 2, current.sec);
            move(current.x - 1, current.sec + 1);
            move(current.x + 1, current.sec + 1);

        }

        return -1;
    }

    static void move(int nextX, int nextSec) {
        if (0 <= nextX && nextX <= MAX_X && !visited[nextX]) {
            queue.add(new FinderInfo(nextX, nextSec));
            visited[nextX] = true;
        }
    }

    static class FinderInfo {
        int x;
        int sec;

        public FinderInfo(int x, int sec) {
            this.x = x;
            this.sec = sec;
        }
    }

}
