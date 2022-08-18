import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, max;
	static int arr[][];
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		max = 0;
		int maxIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			char temp[] = br.readLine().toCharArray();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int) (temp[j] - 'A');
				maxIndex = Math.max(maxIndex, (int) (temp[j] - 'A'));
			}
		}
		isSelected = new boolean[maxIndex + 1];

		solve(0, 0, 1);
		br.close();
		sb.append(max);
		System.out.println(sb);
	}

	static int d[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private static void solve(int yStart, int xStart, int cnt) {
		isSelected[arr[yStart][xStart]] = true;
		for (int i = 0; i < d.length; i++) {
			int dy = yStart + d[i][0];
			int dx = xStart + d[i][1];
			if (isChecked(dy, dx) && !isSelected[arr[dy][dx]]) {
				solve(dy, dx, cnt + 1);
				isSelected[arr[dy][dx]] = false;
			}
		}
		max = Math.max(max, cnt);
	}

	private static boolean isChecked(int y, int x) {
		if (y >= 0 && y < R && x >= 0 && x < C)
			return true;
		return false;
	}

}
