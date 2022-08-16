import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int blueCnt, whiteCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];

		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		squre(arr, N);

		br.close();
		sb.append(whiteCnt).append("\n").append(blueCnt);
		System.out.println(sb);
	}

	private static void squre(int[][] arr, int n) {
		int checkNum = arr[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != checkNum) {
					int[][] temp = newarr(arr, 0, 0, n / 2);
					squre(temp, n / 2);
					temp = newarr(arr, 0, n / 2, n / 2);
					squre(temp, n / 2);
					temp = newarr(arr, n / 2, 0, n / 2);
					squre(temp, n / 2);
					temp = newarr(arr, n / 2, n / 2, n / 2);
					squre(temp, n / 2);
					return;
				}
			}
		}
		if (checkNum == 1)
			++blueCnt;
		else
			++whiteCnt;
	}

	private static int[][] newarr(int[][] arr, int ystart, int xstart, int n) {
		int[][] temp = new int[n][n];
		int y = ystart;
		int x = xstart;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j] = arr[y][x++];
			}
			x = xstart;
			y++;
		}
		return temp;
	}
}
