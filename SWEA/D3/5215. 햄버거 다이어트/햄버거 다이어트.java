import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int max;
	static int N;
	static int L;
	static int[][] ingredient;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/swea_5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			max = 0;

			ingredient = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredient[i][0] = Integer.parseInt(st.nextToken());
				ingredient[i][1] = Integer.parseInt(st.nextToken());
			}
			method(0, 0, 0);
			sb.append(max).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	public static void method(int idx, int score, int sum) {
		if (sum > L)
			return;
		if (idx == N) {
			max = Math.max(max, score);
			return;
		}
		method(idx + 1, score + ingredient[idx][0], sum + ingredient[idx][1]);
		method(idx + 1, score, sum);
	}
}
