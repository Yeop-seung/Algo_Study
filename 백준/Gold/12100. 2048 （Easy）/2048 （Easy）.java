import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int N, ans;
    public static int[][] map;

    public static void main(String[] args) throws IOException {

        init();
        createMap();

        solve(0);
        sb.append(ans);
        br.close();
        System.out.println(sb);
    }

    public static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void solve(int start) {
        if (start >= 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans = Math.max(ans, map[i][j]);
                }
            }
            return;
        }

        int copy[][] = new int[N][N];

        for (int i = 0; i < N; i++)
            copy[i] = map[i].clone();

        for (int i = 0; i < d.length; i++) {
            move(i);
            solve(start + 1);
            for (int j = 0; j < N; j++) {
                map[j] = copy[j].clone();
            }
        }
    }

    private static void move(int i) {
        switch (i) {
            case 0:
                for (int j = 0; j < N; j++) {
                    int index = 0;
                    int block = 0;
                    for (int k = 0; k < N; k++) {
                        if (check(k, j)) {
                            if (map[k][j] == 0) continue;
                            if (block == map[k][j]) {
                                map[index - 1][j] = block * 2;
                                block = 0;
                                map[k][j] = 0;
                            } else {
                                block = map[k][j];
                                map[k][j] = 0;
                                map[index][j] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int j = 0; j < N; j++) {
                    int index = N - 1;
                    int block = 0;
                    for (int k = N - 1; k >= 0; k--) {
                        if (check(j, k)) {
                            if (map[j][k] == 0) continue;
                            if (block == map[j][k]) {
                                map[j][index + 1] = block * 2;
                                block = 0;
                                map[j][k] = 0;
                            } else {
                                block = map[j][k];
                                map[j][k] = 0;
                                map[j][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int j = 0; j < N; j++) {
                    int index = N - 1;
                    int block = 0;
                    for (int k = N - 1; k >= 0; k--) {
                        if (check(k, j)) {
                            if (map[k][j] == 0) continue;
                            if (block == map[k][j]) {
                                map[index + 1][j] = block * 2;
                                block = 0;
                                map[k][j] = 0;
                            } else {
                                block = map[k][j];
                                map[k][j] = 0;
                                map[index][j] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int j = 0; j < N; j++) {
                    int index = 0;
                    int block = 0;
                    for (int k = 0; k < N; k++) {
                        if (check(j, k)) {
                            if (map[j][k] == 0) continue;
                            if (block == map[j][k]) {
                                map[j][index - 1] = block * 2;
                                block = 0;
                                map[j][k] = 0;
                            } else {
                                block = map[j][k];
                                map[j][k] = 0;
                                map[j][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
        }
    }

    private static boolean check(int dy, int dx) {
        return dy >= 0 && dx >= 0 && dy < N && dx < N;
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
        ans = 0;
        map = new int[N][N];
    }
}
