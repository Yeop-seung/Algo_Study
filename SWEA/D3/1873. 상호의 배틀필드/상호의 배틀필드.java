import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/swea_1873.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] field = new char[H][W];
			int y = 0;
			int x = 0;
			for (int i = 0; i < H; i++) {
				String fieldInput = br.readLine();
				for (int j = 0; j < W; j++) {
					field[i][j] = fieldInput.charAt(j);
					if (field[i][j] == '<' || field[i][j] == '^' || field[i][j] == '>' || field[i][j] == 'v') {
						y = i;
						x = j;
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			char[] inputArr = new char[input.length()];
			for (int i = 0; i < input.length(); i++) {
				inputArr[i] = input.charAt(i);
			}
			for (int i = 0; i < inputArr.length; i++) {
				switch (inputArr[i]) {
				case 'U':
					field[y][x] = '^';
					if (y - 1 >= 0 && field[y - 1][x] == '.') {
						field[y - 1][x] = '^';
						field[y][x] = '.';
						y--;
					}
					break;
				case 'D':
					field[y][x] = 'v';
					if (y + 1 < H && field[y + 1][x] == '.') {
						field[y + 1][x] = 'v';
						field[y][x] = '.';
						y++;
					}
					break;
				case 'L':
					field[y][x] = '<';
					if (x - 1 >= 0 && field[y][x - 1] == '.') {
						field[y][x - 1] = '<';
						field[y][x] = '.';
						x--;
					}
					break;
				case 'R':
					field[y][x] = '>';
					if (x + 1 < W && field[y][x + 1] == '.') {
						field[y][x + 1] = '>';
						field[y][x] = '.';
						x++;
					}
					break;
				case 'S':
					int dy = 0;
					int dx = 0;
					switch (field[y][x]) {
					case '^':
						dy = y;
						dx = x;
						while (true) {
							if (dy < 0)
								break;
							if (field[dy][dx] == '*' || field[dy][dx] == '#') {
								if (field[dy][dx] == '*') {
									field[dy][dx] = '.';
									break;
								} else
									break;
							}
							dy--;
						}
						break;
					case 'v':
						dy = y;
						dx = x;
						while (true) {
							if (dy >= H)
								break;
							else if (field[dy][dx] == '*' || field[dy][dx] == '#') {
								if (field[dy][dx] == '*') {
									field[dy][dx] = '.';
									break;
								} else
									break;
							}
							dy++;
						}
						break;
					case '<':
						dy = y;
						dx = x;
						while (true) {
							if (dx < 0)
								break;
							if (field[dy][dx] == '*' || field[dy][dx] == '#') {
								if (field[dy][dx] == '*') {
									field[dy][dx] = '.';
									break;
								} else
									break;
							}
							dx--;
						}
						break;
					case '>':
						dy = y;
						dx = x;
						while (true) {
							if (dx >= W)
								break;
							if (field[dy][dx] == '*' || field[dy][dx] == '#') {
								if (field[dy][dx] == '*') {
									field[dy][dx] = '.';
									break;
								} else
									break;
							}
							dx++;
						}
						break;
					}
					break;
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

}
