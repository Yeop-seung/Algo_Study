import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, ans;
	static int[][] map;
	static boolean[] isSelected;
	static int[] archer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isSelected = new boolean[M];
		archer = new int[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve();

		sb.append(ans);
		br.close();
		System.out.println(sb);
	}

	private static void solve() {

		shoot(0, 0, copy(map));

		for (int i = 0; i < N; i++) {

		}
	}

	private static int[][] copy(int[][] map) {
		int temp[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}

	static int savePoint;

	private static void shoot(int start, int index, int[][] map) {
		if (index == 3) {
			savePoint = 0;
			for (int p = 0; p < N; p++) {
				for (int k = 1; k <= D; k++) {
					go: for (int i = 0; i < archer.length; i++) {
						if (isSelected[i])
							continue;
						for (int v = 0; v < M; v++) {
							for (int j = N - 1; j >= 0; j--) {
								if (map[j][v] == 0)
									continue;
								if (Math.abs(j - N) + Math.abs(v - archer[i]) <= k) {
									isSelected[i] = true;
									map[j][v]++;
									continue go;
								}
							}
						}
					}
				}

				Arrays.fill(isSelected, false);
				int cnt = 0;
				here: for (int j = N - 1; j >= 0; j--) {
					for (int v = 0; v < M; v++) {
						if (map[j][v] != 1 && map[j][v] != 0) {
							cnt++;
							map[j][v] = 0;
							if (cnt == 3)
								break here;
						}
					}
				}
				savePoint += cnt;
				enemyDown(map);
			}
			ans = Math.max(ans, savePoint);
			return;
		}

		for (int i = start; i < M; i++) {
			archer[index] = i;
			shoot(i + 1, index + 1, copy(map));
		}
	}

	private static void enemyDown(int[][] map) {
		for (int j = N - 1; j > 0; j--) {
			for (int v = 0; v < M; v++) {
				map[j][v] = map[j - 1][v];
			}
		}
		for (int j = 0; j < M; j++) {
			map[0][j] = 0;
		}
	}
}
