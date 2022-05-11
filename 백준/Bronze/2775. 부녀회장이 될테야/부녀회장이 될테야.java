import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int t = Integer.parseInt(br.readLine());
			int k = 0;
			int n = 0;
			int[][] room = new int[15][15];

			for (int i = 0; i < 15; i++) {
				room[i][1] = 1;
				room[0][i] = i;
			}

			for (int i = 1; i < 15; i++) {
				for (int j = 2; j < 15; j++) {
					room[i][j] = room[i - 1][j] + room[i][j - 1];
				}
			}

			for (int i = 0; i < t; i++) {
				k = Integer.parseInt(br.readLine());
				n = Integer.parseInt(br.readLine());

				sb.append(room[k][n]).append("\n");
			}
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}