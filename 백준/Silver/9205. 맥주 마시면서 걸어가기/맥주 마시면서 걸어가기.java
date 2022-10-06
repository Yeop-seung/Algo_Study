import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] home, fastival;
	static List<int[]> store;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			int n = Integer.parseInt(br.readLine());

			home = new int[2];
			store = new ArrayList<int[]>();
			fastival = new int[2];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 2; i++) {
				home[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				store.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}
			visited = new boolean[store.size()];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 2; i++) {
				fastival[i] = Integer.parseInt(st.nextToken());
			}

			boolean flag = solve(home[0], home[1]);

			if (flag)
				sb.append("happy").append("\n");
			else
				sb.append("sad").append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static boolean solve(int homeY, int homeX) {
		if (Math.abs(fastival[0] - homeY) + Math.abs(fastival[1] - homeX) <= 1000) {
			return true;
		}
		for (int i = 0; i < store.size(); i++) {
			if (visited[i])
				continue;
			int[] temp = store.get(i);

			int targetY = temp[0];
			int targetX = temp[1];

			if (Math.abs(targetY - homeY) + Math.abs(targetX - homeX) <= 1000) {
				visited[i] = true;
				if (solve(targetY, targetX))
					return true;
			}
		}
		return false;
	}
}
