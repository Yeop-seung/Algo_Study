import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int N, M, K, ans;
    public static int[][] map;
    public static boolean[][][] visited;
    public static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        init();
        createMap();
        bfs();
        br.close();
        sb.append(ans);
        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        // y, x, 벽 뚫은 수 , 최소 거리
        q.offer(new int[]{0, 0, 0, 1});
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int wall = temp[2];
            int dist = temp[3];
            if (y == N - 1 && x == M - 1) {
                ans = dist;
                return;
            }
            for (int i = 0; i < d.length; i++) {
                int dy = y + d[i][0];
                int dx = x + d[i][1];
                if (check(dy, dx)) {
                    if (map[dy][dx] == 0 && !visited[dy][dx][wall]) {
                        visited[dy][dx][wall] = true;
                        q.offer(new int[]{dy, dx, wall, dist + 1});
                    } else if (map[dy][dx] == 1 && wall < K && !visited[dy][dx][wall + 1]) {
                        visited[dy][dx][wall + 1] = true;
                        q.offer(new int[]{dy, dx, wall + 1, dist + 1});
                    }
                }
            }
        }
    }

    private static boolean check(int dy, int dx) {
        return dy >= 0 && dx >= 0 && dy < N && dx < M;
    }


    private static void createMap() throws IOException {
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = -1;
        map = new int[N][M];
        visited = new boolean[N][M][K + 1];
    }
}
