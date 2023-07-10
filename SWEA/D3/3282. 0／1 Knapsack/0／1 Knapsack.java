import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static int T, N, K, ans;
    public static int[] V, C;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            init(t);

            solve();

            put();
        }
        br.close();
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static void put() {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        sb.append(ans).append("\n");
    }

    public static int[][] dp;

    private static void solve() {
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (V[i] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - V[i]] + C[i]);
            }
        }
    }

    private static void init(int t) throws IOException {
        sb.append("#").append(t).append(" ");

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ans = 0;

        V = new int[N + 1];
        C = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            V[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }
    }
}
