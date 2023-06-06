import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int R, C;
    public static int oCnt, vCnt = 0;
    public static int ansOCnt, ansVCnt = 0;
    public static char[][] map;
    public static boolean[][] visited;
    public static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        solve();

        sb.append(ansOCnt).append(" ").append(ansVCnt);
        br.close();
        System.out.println(sb);
    }

    public static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void solve() {
        listAdd();
        visited = new boolean[R][C];
        for (int[] temp :
                list) {
            oCnt = 0;
            vCnt = 0;
            bfs(temp);

            if (vCnt >= oCnt && !(oCnt == 0 && vCnt == 0))
                ansVCnt += vCnt;
            else if (oCnt > vCnt)
                ansOCnt += oCnt;
        }
    }

    private static void bfs(int[] temp) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(temp[1], temp[0]));
        visited[temp[0]][temp[1]] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (map[p.y][p.x] == 'o')
                oCnt++;
            else if (map[p.y][p.x] == 'v')
                vCnt++;
            for (int i = 0; i < d.length; i++) {
                int dy = p.y + d[i][0];
                int dx = p.x + d[i][1];
                if (check(dy, dx) && !visited[dy][dx] && map[dy][dx] != '#') {
                    visited[dy][dx] = true;
                    q.offer(new Point(dx, dy));
                }
            }
        }

    }

    private static void listAdd() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    list.add(new int[]{i, j});
                    visited[i][j] = true;
                    listDfs(i, j);
                }
            }
        }
    }

    private static void listDfs(int y, int x) {
        for (int i = 0; i < d.length; i++) {
            int dy = y + d[i][0];
            int dx = x + d[i][1];
            if (check(dy, dx) && !visited[dy][dx] && map[dy][dx] != '#') {
                visited[dy][dx] = true;
                listDfs(dy, dx);
            }
        }
    }

    private static boolean check(int dy, int dx) {
        return dx >= 0 && dy >= 0 && dy < R && dx < C;
    }
}
