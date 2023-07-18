import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int R, C, K, ans = 0;

    public static char[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();

        solve(R - 1, 0, 1);

        System.out.println(ans);
    }

    public static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void solve(int y, int x, int cnt) {
        if (cnt > K) return;
        if (y == 0 && x == C - 1 && cnt == K) {
            ans++;
            return;
        }
        for (int i = 0; i < d.length; i++) {
            int dy = y + d[i][0];
            int dx = x + d[i][1];
            if (check(dy, dx) && !visited[dy][dx]) {
                visited[dy][dx] = true;
                solve(dy, dx, cnt + 1);
                visited[dy][dx] = false;
            }
        }
    }

    private static boolean check(int dy, int dx) {
        return dy >= 0 && dx >= 0 && dy < R && dx < C;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
                if (map[i][j] == 'T')
                    visited[i][j] = true;
            }
        }
        visited[R - 1][0] = true;
    }
}
