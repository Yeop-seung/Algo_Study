import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 1; i <= t; i++) {
				sb.append("#").append(i).append("\n");
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int[][] arr = new int[n][n];
				int[][] temp = new int[n][n];
				int[][][] answer = new int[3][n][n];
				for (int j = 0; j < n; j++) {
					st = new StringTokenizer(br.readLine());
					for (int v = 0; v < n; v++) {
						arr[j][v] = Integer.parseInt(st.nextToken());
					}
				}
				int x = 0;
				int y = n - 1;
				for (int j = 0; j < 3; j++) {
					for (int v = 0; v < n; v++) {
						for (int p = 0; p < n; p++) {
							temp[v][p] = arr[y--][x];
						}
						y = n - 1;
						x++;
					}
					for (int v = 0; v < n; v++) {
						for (int p = 0; p < n; p++) {
							answer[j][v][p] = temp[v][p];
						}
					}
					arr = answer[j];
					x = 0;
				}

				for (int j = 0; j < n; j++) {
					for (int v = 0; v < 3; v++) {
						for (int p = 0; p < n; p++) {
							sb.append(answer[v][j][p]);
						}
						sb.append(" ");
					}
					sb.append("\n");
				}
			}
			br.close();
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
		} catch (Exception e) { //
			System.out.println(e.toString());
		}
	}
}