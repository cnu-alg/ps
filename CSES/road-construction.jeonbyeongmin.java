
import java.io.*;
import java.util.StringTokenizer;

/**
 * Hello world!
 *
 */
public class App {

    public static int n;
    public static int m;
    public static int[] parent;
    public static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }

        int max = 1;
        int cc = n;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a) != find(b)) {
                max = Math.max(union(a, b), max);
                cc--;
            }

            bw.write(cc + " " + max + "\n");
        }

        bw.close();

    }

    public static int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return x;
    }

    public static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (rank[a] < rank[b]) {
            parent[a] = b;
            rank[b] += rank[a];
        } else {
            parent[b] = a;
            rank[a] += rank[b];
        }

        return Math.max(rank[a], rank[b]);
    }

}
