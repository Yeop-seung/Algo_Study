import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception, IOException {
		//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//
//        for (int t = 1; t <= T; t++) {
//            sb.append("#").append(t).append("\n");
//            int N = Integer.parseInt(br.readLine());
//            int[][] arr = new int[N][N];
//            int num = 1;
//            int cnt = 0;
//            for (int i = 0; i < N; i++) {
//                arr[0][i] = num++;
//            }
//            cnt++;
//            int y = 0;
//            int x = N - 1;
//            int check = 0;
//            while (N - cnt != 0) {
//                switch (check % 2) {
//                    case 0:
//                        for (int i = 0; i < N - cnt; i++) {
//                            arr[++y][x] = num++;
//                        }
//                        for (int i = 0; i < N - cnt; i++) {
//                            arr[y][--x] = num++;
//                        }
//                        cnt++;
//                        check++;
//                        break;
//                    case 1:
//                        for (int i = 0; i < N - cnt; i++) {
//                            arr[--y][x] = num++;
//                        }
//                        for (int i = 0; i < N - cnt; i++) {
//                            arr[y][++x] = num++;
//                        }
//                        cnt++;
//                        check++;
//                        break;
//                }
//            }
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[i].length; j++) {
//                    sb.append(arr[i][j]).append(" ");
//                }
//                sb.append("\n");
//            }
//        }
//        br.close();
//        sb.setLength(sb.length() - 1);
//        System.out.println(sb);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int testcase = 1; testcase <= T; testcase++) {
            int N = Integer.parseInt(br.readLine().trim());

            int[][] snail = new int[N][N];
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};

            int row = 0;
            int col = 0;
            int dir = 0;

            for (int i = 1; i <= N * N; i++) {
                snail[row][col] = i;

                int nextRow = row + dr[dir];
                int nextCol = col + dc[dir];

                if (nextRow < 0 || nextRow >= N || nextCol >= N || nextCol < 0 || snail[nextRow][nextCol] != 0)
                    dir = (dir + 1) % 4;

                row += dr[dir];
                col += dc[dir];
            }

            sb.append("#").append(testcase).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(snail[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        if (sb.length() != 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
	}
}
