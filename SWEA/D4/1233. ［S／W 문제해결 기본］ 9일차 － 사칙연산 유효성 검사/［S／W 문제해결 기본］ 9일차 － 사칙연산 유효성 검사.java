import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static String[] arr;

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/swea_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		int T = 10;
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			int N = Integer.parseInt(br.readLine());
			arr = new String[N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			loop(N);

		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static void loop(int N) {
		int level = 0;
		int skip = N;
		boolean check = false;
		while (skip != 1) {
			skip = skip / 2;
			++level;
		}
		for (int i = 0; i < level; i++) {
			skip *= 2;
		}
		if (skip == N)
			skip /= 2;
		for (int i = skip + 1; i <= N; i++) {
			if (arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*") || arr[i].equals("/"))
				check = true;
		}
		if (check)
			sb.append(0).append("\n");
		else
			sb.append(1).append("\n");
	}

}
