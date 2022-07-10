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
				sb.append("#").append(i).append(" ");
				int[][] sudoku = new int[9][9];
				boolean[] check = new boolean[9];
				for (int j = 0; j < 9; j++) {
					st = new StringTokenizer(br.readLine());
					for (int v = 0; v < 9; v++) {
						sudoku[j][v] = Integer.parseInt(st.nextToken());
					}
				}
				pass: for (int j = 0; j < 9; j++) {
					for (int v = 0; v < 9; v++) {
						if (check[sudoku[j][v] - 1] == true) {
							sb.append(0).append("\n");
							break pass;
						} else if (check[sudoku[j][v] - 1] == false) {
							check[sudoku[j][v] - 1] = true;
						}
					}
					for (int p = 0; p < 9; p++) {
						check[p] = false;
					}
					for (int v = 0; v < 9; v++) {
						if (check[sudoku[v][j] - 1] == true) {
							sb.append(0).append("\n");
							break pass;
						} else if (check[sudoku[v][j] - 1] == false) {
							check[sudoku[v][j] - 1] = true;
						}
					}
					for (int p = 0; p < 9; p++) {
						check[p] = false;
					}
					int x = 0;
					int y = 0;
					for (int o = 0; o < 3; o++) {
						for (int z = 0; z < 3; z++) {
							for (int v = y; v < y + 3; v++) {
								for (int p = x; p < x + 3; p++) {
									if (check[sudoku[v][p] - 1] == true) {
										sb.append(0).append("\n");
										break pass;
									} else if (check[sudoku[v][p] - 1] == false) {
										check[sudoku[v][p] - 1] = true;
									}
								}
							}
							x += 3;
						}
					}
					for (int p = 0; p < 9; p++) {
						check[p] = false;
					}
					if (j == 8) {
						sb.append(1).append("\n");
					}
				}
			}
			br.close();
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
		} //
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}