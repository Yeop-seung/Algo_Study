import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int d[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static char arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int ans = 0;
		for (int i = 0; i < R; i++) {
			if (solve(i, 0))
				++ans;
		}
		br.close();
		sb.append(ans);
		System.out.println(sb);
	}

	private static boolean solve(int y, int x) {
		if (y >= 0 && y < arr.length && x == arr[0].length - 1) {
			arr[y][x] = 'x';
			return true;
		}

		arr[y][x] = 'x';
		for (int i = 0; i < d.length; i++) {
			int dy = y + d[i][0];
			int dx = x + d[i][1];
			if (dy < 0 || dy >= arr.length || dx < 0 || dx >= arr[0].length)
				continue;
			if (arr[dy][dx] == 'x')
				continue;
			if (solve(dy, dx)) {
				return true;
			}
		}
		return false;
	}

}
