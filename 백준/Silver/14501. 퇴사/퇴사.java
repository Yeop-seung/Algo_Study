import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, ans;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[2][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            check(i, 0, i);
        }

        System.out.println(ans);
    }

    private static void check(int day, int sum, int checkDay) {
        if (day == N + 1) {
            ans = Math.max(sum, ans);
            return;
        }
        if (day >= checkDay) {
            if (day + (arr[0][day] - 1) >= N + 1)
                check(day + 1, sum, checkDay);
            else {
                check(day + 1, sum + arr[1][day], day + arr[0][day]);
                check(day + 1, sum, checkDay);

            }
        } else
            check(day + 1, sum, checkDay);
    }
}

