import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/swea_7272.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		char[][] check = {
				{ 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' },
				{ 'A', 'D', 'O', 'P', 'Q', 'R' }, { 'B' } };
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			String[] str1 = st.nextToken().split("");
			String[] str2 = st.nextToken().split("");

			if (str1.length != str2.length)
				sb.append("DIFF").append("\n");
			else {
				for (int i = 0; i < str1.length; i++) {
					for (int j = 0; j < check.length; j++) {
						int num = j + 1;
						for (int j2 = 0; j2 < check[j].length; j2++) {
							if (str1[i].charAt(0) == check[j][j2])
								str1[i] = Integer.toString(num);
							if (str2[i].charAt(0) == check[j][j2])
								str2[i] = Integer.toString(num);
						}
					}
				}
				int cnt = 0;
				for (int i = 0; i < str2.length; i++) {
					if (str1[i].equals(str2[i]))
						cnt++;
				}
				if (cnt == str1.length)
					sb.append("SAME").append("\n");
				else
					sb.append("DIFF").append("\n");
			}
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
