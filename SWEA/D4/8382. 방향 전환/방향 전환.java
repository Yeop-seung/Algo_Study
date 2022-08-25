import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int ans;
	static int[] start, end;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			start = new int[2];
			end = new int[2];

			st = new StringTokenizer(br.readLine());

			start[1] = Integer.parseInt(st.nextToken());
			start[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			end[0] = Integer.parseInt(st.nextToken());

			if (start[0] < 0) {
				end[0] += Math.abs(start[0]);
				start[0] += Math.abs(start[0]);
			}
			if (start[1] < 0) {
				end[1] += Math.abs(start[1]);
				start[1] += Math.abs(start[1]);
			}
			if (end[0] < 0) {
				start[0] += Math.abs(end[0]);
				end[0] += Math.abs(end[0]);
			}
			if (end[1] < 0) {
				start[1] += Math.abs(end[1]);
				end[1] += Math.abs(end[1]);
			}

			ans = Integer.MAX_VALUE;
			for (int i = 0; i < 2; i++) {
				visit = new boolean[201][201];
				solve(i);
			}
			sb.append(ans).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static int[][][] d = { { { 1, 0 }, { -1, 0 } }, { { 0, 1 }, { 0, -1 } } };

	private static void solve(int idx) {
		int y1 = start[0];
		int x1 = start[1];

		Queue<int[]> queue = new ArrayDeque<int[]>();

		queue.offer(new int[] { y1, x1, 0 });
		visit[y1][x1] = true;
		g: while (!queue.isEmpty()) {
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				int[] temp = queue.poll();

				if (temp[0] == end[0] && temp[1] == end[1]) {
					ans = Math.min(ans, temp[2]);
					break g;
				}
				for (int j = 0; j < d[idx % 2].length; j++) {
					int dy = temp[0] + d[idx][j][0];
					int dx = temp[1] + d[idx][j][1];
					if (isChecked(dy, dx) && !visit[dy][dx]) {
						visit[dy][dx] = true;
						queue.offer(new int[] { dy, dx, temp[2] + 1 });
					}
				}
			}
			idx = (idx + 1) % 2;
		}
	}

	private static boolean isChecked(int dy, int dx) {
		return dy >= 0 && dx >= 0 && dy <= 200 && dx <= 200;
	}
}
