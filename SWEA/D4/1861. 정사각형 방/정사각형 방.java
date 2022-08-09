import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int max = -1;
	static int minStart = Integer.MAX_VALUE;
	static int[][] check, arr;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/swea_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		check = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		for (int t = 1, T = Integer.parseInt(br.readLine()); t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int N = Integer.parseInt(br.readLine());

			arr = new int[N + 2][N + 2];
			for (int i = 0; i < arr.length; i++) {
				Arrays.fill(arr[i], -1);
			}

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int y = i;
					int x = j;
					int start = arr[y][x];
					loop(start, y, x, 1);
				}
			}
			sb.append(minStart).append(" ").append(max).append("\n");
			max = -1;
			minStart = Integer.MAX_VALUE;
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static void loop(int start, int y, int x, int cnt) {
		while (true) {
			for (int j2 = 0; j2 < check.length; j2++) {
				int dy = y + check[j2][0];
				int dx = x + check[j2][1];

				if (arr[dy][dx] == arr[y][x] + 1) {
					loop(start, dy, dx, cnt + 1);
				}
			}
			if (max == cnt) {
				if (minStart > start) {
					minStart = start;
				}
			}
			if (max < cnt) {
				minStart = start;
				max = cnt;
			}
			return;
		}
	}

}
