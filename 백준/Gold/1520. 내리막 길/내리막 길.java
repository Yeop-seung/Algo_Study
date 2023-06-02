import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map, arr;
    public static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        arr = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = -1;
            }
        }

        System.out.println(solve(0, 0));
        br.close();
    }

    public static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int solve(int y, int x) {
        if (y == M - 1 && x == N - 1)
            return 1;
        if (arr[y][x] != -1)
            return arr[y][x];
        arr[y][x] = 0;
        for (int i = 0; i < d.length; i++) {
            int dy = y + d[i][0];
            int dx = x + d[i][1];
            if (check(dy, dx)) {
                if (map[y][x] > map[dy][dx])
                    arr[y][x] += solve(dy, dx);
            }
        }
        return arr[y][x];
    }

    private static boolean check(int dy, int dx) {
        if (dy >= 0 && dx >= 0 && dy < M && dx < N)
            return true;
        return false;
    }
}
