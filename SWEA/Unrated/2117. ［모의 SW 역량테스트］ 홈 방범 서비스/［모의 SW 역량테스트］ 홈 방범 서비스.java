import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, max;
	static List<int[]> home;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];

			max = 0;
			home = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						home.add(new int[] { i, j });
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean isSelected[][] = new boolean[N][N];
					isSelected[i][j] = true;
					bfs(i, j, isSelected);
				}
			}

			sb.append(max).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static int d[][] = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

	private static void bfs(int y, int x, boolean[][] isSelected) {
		int dy = y;
		int dx = x;
		for (int i = 0; i <= N + 1; i++) {
			
			for (int j = 0; j < d.length; j++) {
				for (int v = 0; v < i; v++) {
					dy = dy + d[j][0];
					dx = dx + d[j][1];
					if (checked(dy, dx)) {
						isSelected[dy][dx] = true;
					}
				}
			}
			dy--;
			int cnt = 0;
			for (int j = 0; j < home.size(); j++) {
				int temp[] = home.get(j);
				if (isSelected[temp[0]][temp[1]])
					++cnt;
			}
			int k = i + 1;
			if (cnt * M - (k * k + (k - 1) * (k - 1)) >= 0)
				max = Math.max(max, cnt);
			
		}
	}

	private static boolean checked(int dy, int dx) {
		if (dy >= 0 && dy < N && dx >= 0 && dx < N)
			return true;
		return false;
	}

}
