import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int max;
	static List<Integer>[] list;

	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/swea_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			list = new ArrayList[N + 1];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}
			isSelected = new boolean[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}

			solve(start);
			sb.append(ans[1]).append("\n");

		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static int[] ans = new int[2];

	private static void solve(int start) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		int cnt = 0;
		queue.offer(new int[] { start, cnt });
		isSelected[start] = true;
		while (!queue.isEmpty()) {
			int[] num = queue.poll();

			if (ans[0] != num[1]) {
				max = 0;
				ans[1] = 0;
			}
			ans[0] = num[1];
			ans[1] = Math.max(ans[1], num[0]);
			for (int i = 0; i < list[num[0]].size(); i++) {
				if (isSelected[list[num[0]].get(i)])
					continue;
				max = Math.max(max, list[num[0]].get(i));
				isSelected[list[num[0]].get(i)] = true;
				queue.offer(new int[] { list[num[0]].get(i), num[1] + 1 });
			}
		}
	}
}