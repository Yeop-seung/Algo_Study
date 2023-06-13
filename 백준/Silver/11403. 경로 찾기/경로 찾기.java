import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        createMap();
        solve();
        br.close();
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static void solve() {
        // i~j j~k가 된다면
        // i~k
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1)
                        map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                sb.append(map[i][j]).append(" ");
            sb.append("\n");
        }
    }

    private static void createMap() throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }


    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
    }
}
