import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
public static int flattening(int[][] box) {
        for (int j = 100; j >= 1; j--) {
            for (int k = 1; k <= 100; k++) {
                if (box[j][k] == 1) {
                    for (int l = 1; l <= 100; l++) {
                        for (int v = 1; v <= 100; v++) {
                            if (box[l][v] == 1) {
                                if (j == l) return 0;
                                box[j][k] = 0;
                                box[j - 1][k] = 1;
                                box[l][v] = 0;
                                box[l + 1][v] = 1;
                                return j - l;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int testcase = 1; testcase <= 10; testcase++) {
            int dump = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[][] box = new int[101][101];
            int maxHeight = Integer.MIN_VALUE;
            int minHeight = Integer.MAX_VALUE;
            for (int i = 1; i <= 100; i++) {
                int height = Integer.parseInt(st.nextToken());
                if (maxHeight < height) maxHeight = height;
                if (minHeight > height) minHeight = height;
                box[height][i] = 1;
            }
            int ans = 0;
            if (maxHeight == minHeight) ans = 0;
            else {
                while (dump >= 0) {
                    ans = flattening(box);
                    if (ans == 0) break;
                    dump--;
                }
            }


            sb.append("#").append(testcase).append(" ").append(ans).append("\n");

        }
        if (sb.length() != 0)
            sb.setLength(sb.length() - 1);

        System.out.println(sb);
        
	}

}
