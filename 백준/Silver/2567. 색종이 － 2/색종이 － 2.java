import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		int[][] check = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x2 = x + 10;
			int y2 = y + 10;

			for (int j = y; j < y2; j++) {
				for (int j2 = x; j2 < x2; j2++) {
					if (arr[j][j2] != 1)
						arr[j][j2] = 1;
				}
			}

		}

		for (int j = 1; j < 100; j++) {
			for (int j2 = 1; j2 < 100; j2++) {
				if (arr[j][j2] == 1) {
					for (int k = 0; k < check.length; k++) {
						int dx = j2 + check[k][1];
						int dy = j + check[k][0];

						if (arr[dy][dx] == 0)
							cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
