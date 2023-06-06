import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static int N, ans;
    public static int sharkY, sharkX, sharkSize, sizeCnt;
    public static int targetY, targetX, targetDistance;
    public static int[][] map, distance;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        ans = 0;

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }
        sharkSize = 2;
        sizeCnt = 0;

        while (true) {
            distance = new int[N][N];
            targetX = Integer.MAX_VALUE;
            targetY = Integer.MAX_VALUE;
            targetDistance = Integer.MAX_VALUE;

            bfs(sharkX, sharkY);

            if (targetX != Integer.MAX_VALUE && targetY != Integer.MAX_VALUE) {
                sizeCnt++;
                map[targetX][targetY] = 0;
                sharkX = targetX;
                sharkY = targetY;
                ans += distance[targetX][targetY];

                if (sizeCnt == sharkSize) {
                    sharkSize++;
                    sizeCnt = 0;
                }
            } else break;
        }
        sb.append(ans);
        br.close();
        System.out.println(sb);
    }

    public static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void bfs(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < d.length; i++) {
                int dx = p.x + d[i][0];
                int dy = p.y + d[i][1];

                if (check(dx, dy) && map[dx][dy] <= sharkSize && distance[dx][dy] == 0) {
                    distance[dx][dy] = distance[p.x][p.y] + 1;

                    if (map[dx][dy] != 0 && map[dx][dy] < sharkSize) {
                        if (targetDistance > distance[dx][dy]) {
                            targetDistance = distance[dx][dy];
                            targetX = dx;
                            targetY = dy;
                        } else if (targetDistance == distance[dx][dy]) {
                            if (targetX == dx) {
                                if (targetY > dy) {
                                    targetX = dx;
                                    targetY = dy;
                                }
                            } else if (targetX > dx) {
                                targetX = dx;
                                targetY = dy;
                            }
                        }
                    }
                    q.offer(new Point(dx, dy));
                }
            }
        }
    }

    private static boolean check(int dx, int dy) {
        return dy >= 0 && dx >= 0 && dy < N && dx < N;
    }
}