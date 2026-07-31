import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception, IOException {
       //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        int[][] arr = new int[100][100];
//        for (int t = 1; t <= 10; t++) {
//            int T = Integer.parseInt(br.readLine());
//            sb.append("#").append(T).append(" ");
//            for (int i = 0; i < arr.length; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < arr[i].length; j++) {
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//            int x = 0;
//            int y = 0;
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[99][i] == 2) {
//                    x = i;
//                    y = 99;
//                }
//            }
//
//            while (y != 0) {
//
//                if (x < 99 && arr[y][x + 1] == 1) {
//                    while (x < 99 && arr[y][x + 1] == 1) {
//                        ++x;
//                    }
//
//                } else if (x > 0 && arr[y][x - 1] == 1) {
//                    while (x > 0 && arr[y][x - 1] == 1) {
//                        --x;
//                    }
//                }
//                y--;
//            }
//            sb.append(x).append("\n");
//        }
//        br.close();
//        sb.setLength(sb.length() - 1);
//        System.out.println(sb);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int testcase = 1; testcase <= 10; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[][] map = new int[100][100];
            int ans = 0;
            int y = 99;
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map.length; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < map.length; i++)
                if (map[99][i] == 2) ans = i;

            while (y > 0) {
                if (ans > 0 && map[y][ans - 1] == 1)
                    while (ans > 0 && map[y][ans - 1] == 1) ans--;
                else if (ans < 99 && map[y][ans + 1] == 1)
                    while (ans < 99 && map[y][ans + 1] == 1) ans++;
                y--;
            }
            sb.append("#").append(testcase).append(" ").append(ans).append("\n");
        }

        if (sb.length() != 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
	}
}
