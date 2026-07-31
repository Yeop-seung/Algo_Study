import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception, IOException {
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
