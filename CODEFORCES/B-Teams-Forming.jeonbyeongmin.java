import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n is even
        int[] ai = new int[n];

        for (int i = 0; i < n; i++) {
            ai[i] = sc.nextInt();
        }

        Arrays.sort(ai);
        int answer = 0;

        for (int i = 0; i < n - 1; i = i + 2) {
            answer += ai[i + 1] - ai[i];
        }

        System.out.println(answer);

        sc.close();
    }
}
