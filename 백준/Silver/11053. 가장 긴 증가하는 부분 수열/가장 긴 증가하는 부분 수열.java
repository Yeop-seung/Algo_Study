import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int N = 0;
    public static int min = Integer.MAX_VALUE;
    public static int[] num, len;

    public static void main(String[] args) throws IOException {
        init();

        solve();

        int ans = -1;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, len[i]);
        }

        sb.append(ans);
        br.close();
        System.out.println(sb);
    }

    private static void solve() {
        // dp
        for (int i = 0; i < N; i++) {
            len[i] = 1;

            // 0 ~ i 이전 원소들 탐색
            for (int j = 0; j < i; j++) {

                // j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
                if (num[j] < num[i] && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;    // j번째 원소의 +1 값이 i번째 dp가 된다.
                }
            }
        }
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        len = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            len[i] = 1;
        }
    }
}
