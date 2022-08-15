import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans, min;

	static boolean isSelected[];
	static List<int[]> home, store;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		home = new ArrayList<>();
		store = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					home.add(new int[] { i, j });
				else if (map[i][j] == 2)
					store.add(new int[] { i, j });
			}
		}
		isSelected = new boolean[store.size()];
		comb(0, 0);
		sb.append(ans);
		br.close();
		System.out.println(sb);

	}

	private static void comb(int cnt, int index) {
		if (cnt == store.size()) {
			int temp = 0;
			if (index == M) {
				for (int i = 0; i < home.size(); i++) {
					int[] homePoint = home.get(i);
					min = Integer.MAX_VALUE;
					for (int j = 0; j < store.size(); j++) {
						if (!isSelected[j])
							continue;
						int[] storePoint = store.get(j);
						check(homePoint[0], homePoint[1], storePoint[0], storePoint[1]);
					}
					temp += min;
				}
			}
			if (temp != 0)
				ans = Math.min(ans, temp);
			return;
		}

		isSelected[cnt] = true;
		comb(cnt + 1, index + 1);
		isSelected[cnt] = false;
		comb(cnt + 1, index);

	}

	private static void check(int hI, int hJ, int sI, int sJ) {
		min = Math.min(min, Math.abs(hI - sI) + Math.abs(hJ - sJ));
	}
}
