import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int N, L, R;
    public static int ans, sum;

    public static int[][] map;
    public static List<int[]> list;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        br.close();
        sb.append(ans);
        System.out.println(sb);
    }

    private static void solve() {
        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                        if (list.size() > 1) {
                            chage();
                            flag = true;
                        }
                    }
                }
            }
            if (flag) ans++;
            else return;
        }
    }

    private static void chage() {
        int temp = sum / list.size();

        for (int[] p :
                list) {
            map[p[0]][p[1]] = temp;
        }
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        list = new ArrayList<>();
        q.offer(new int[]{y, x});
        list.add(new int[]{y, x});
        visited[y][x] = true;
        sum = map[y][x];
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for (int k = 0; k < d.length; k++) {
                int dy = y + d[k][0];
                int dx = x + d[k][1];
                if (check(dy, dx) && (L <= Math.abs(map[y][x] - map[dy][dx]) && Math.abs(map[y][x] - map[dy][dx]) <= R) && !visited[dy][dx]) {
                    visited[dy][dx] = true;
                    q.offer(new int[]{dy, dx});
                    list.add(new int[]{dy, dx});
                    sum += map[dy][dx];
                }
            }
        }
    }

    private static boolean check(int dy, int dx) {
        return dy >= 0 && dx >= 0 && dy < N && dx < N;
    }

    public static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ans = 0;
        sum = 0;

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
