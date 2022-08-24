import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, fIdx, sIdx;
	static int[] dicePoint, dice;
	static int[][] map;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dice = new int[6];
		fIdx = 0;
		sIdx = 0;

		dicePoint = new int[2];
		dicePoint[0] = Integer.parseInt(st.nextToken());
		dicePoint[1] = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			solve(Integer.parseInt(st.nextToken()));
		}

		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
	// 1 3 6 4
	// 5 3 2 4
	// 6 3 1 4
	// 2 3 5 4

	private static void solve(int move) {
		int y = dicePoint[0];
		int x = dicePoint[1];

		int dy = y;
		int dx = x;
		switch (move) {
		case 1:
			dx = dx + 1;
			if (isChecked(dy, dx)) {
				dicePoint[1] += 1;
				int temp = dice[0];

				dice[0] = dice[2];
				dice[2] = dice[5];
				dice[5] = dice[3];
				dice[3] = temp;

				if (map[dy][dx] != 0) {
					dice[0] = map[dy][dx];
					map[dy][dx] = 0;
				} else {
					map[dy][dx] = dice[0];
				}
				sb.append(dice[5]).append("\n");
			}
			break;
		case 2:
			dx = dx - 1;

			if (isChecked(dy, dx)) {
				dicePoint[1] -= 1;

				int temp = dice[0];

				dice[0] = dice[3];
				dice[3] = dice[5];
				dice[5] = dice[2];
				dice[2] = temp;

				if (map[dy][dx] != 0) {
					dice[0] = map[dy][dx];
					map[dy][dx] = 0;
				} else {
					map[dy][dx] = dice[0];
				}
				sb.append(dice[5]).append("\n");
			}
			break;
		case 3:
			dy = dy - 1;

			if (isChecked(dy, dx)) {
				dicePoint[0] -= 1;

				int temp = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[4];
				dice[4] = temp;

				if (map[dy][dx] != 0) {
					dice[0] = map[dy][dx];
					map[dy][dx] = 0;
				} else {
					map[dy][dx] = dice[0];
				}
				sb.append(dice[5]).append("\n");
			}
			break;
		case 4:
			dy = dy + 1;
			if (isChecked(dy, dx)) {
				dicePoint[0] += 1;

				int temp = dice[0];
				dice[0] = dice[4];
				dice[4] = dice[5];
				dice[5] = dice[1];
				dice[1] = temp;

				if (map[dy][dx] != 0) {
					dice[0] = map[dy][dx];
					map[dy][dx] = 0;
				} else {
					map[dy][dx] = dice[0];
				}
				sb.append(dice[5]).append("\n");
			}
			break;

		default:
			break;
		}
	}

	private static boolean isChecked(int dy, int dx) {
		if (dy >= 0 && dx >= 0 && dy < N && dx < M)
			return true;
		return false;
	}
}
