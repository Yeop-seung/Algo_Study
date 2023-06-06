import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N;
    static char[][] map;
    static boolean[][] visited;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        solve();
        br.close();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    static Queue<Point> q = new ArrayDeque<>();

    private static void solve() {
        for (int i = 1; i < N; i++) {
            visited = new boolean[R][C];
            if (i % 2 == 1) {
                // 폭탄 위치 구하기
                getBoom();
                // 빈곳에 폭탄 놓기
                placeBoom();
            } else {
                // 터트리기
                Boom();
            }
        }
    }

    private static void Boom() {
        while (!q.isEmpty()) {
            Point p = q.poll();
            map[p.y][p.x] = '.';
            for (int i = 0; i < d.length; i++) {
                int dy = p.y + d[i][0];
                int dx = p.x + d[i][1];
                if (check(dy, dx) && !visited[dy][dx]) {
                    visited[dy][dx] = true;
                    map[dy][dx] = '.';
                }
            }
        }
    }

    private static void placeBoom() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                }
            }
        }
    }

    private static boolean check(int dy, int dx) {
        return dy >= 0 && dx >= 0 && dy < R && dx < C;
    }

    private static void getBoom() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    visited[i][j] = true;
                    q.offer(new Point(j, i));
                }
            }
        }
    }
}
