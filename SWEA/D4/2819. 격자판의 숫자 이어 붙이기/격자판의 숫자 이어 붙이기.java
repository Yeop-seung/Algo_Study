import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int totalCnt;
	static char map[][];
	static char ans[];
	static Set<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			map = new char[4][4];
			ans = new char[7];
			set = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			totalCnt = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					solve(i, j, 0);
				}
			}
			sb.append(set.size()).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private static void solve(int y, int x, int cnt) {
		if (cnt == 7) {
			String temp = "";
			for (int i = 0; i < ans.length; i++) {
				temp += ans[i];
			}
			set.add(temp);
			return;
		}
		ans[cnt] = map[y][x];
		for (int i = 0; i < 4; i++) {
			if (isChecked(y + d[i][0], x + d[i][1]))
				solve(y + d[i][0], x + d[i][1], cnt + 1);
		}
	}

	private static boolean isChecked(int dy, int dx) {
		if (dy >= 0 && dy < 4 && dx >= 0 && dx < 4)
			return true;
		return false;
	}
}
