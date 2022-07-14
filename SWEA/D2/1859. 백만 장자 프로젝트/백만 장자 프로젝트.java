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
				int n = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine());
				int[] num = new int[n];
				for (int j = 0; j < n; j++) {
					num[j] = Integer.parseInt(st.nextToken());
				}

				int temp = num[0];
				int answer = -temp;
				int count = 1;
				for (int j = 1; j < n; j++) {
					if (temp < num[j]) {
						temp = num[j];
						int temp2 = temp;
						for (int v = j + 1; v < n; v++) {
							if (temp2 < num[v]) {
								temp2 = num[v];
							}
						}
						if (temp != temp2) {
							answer -= num[j];
							count++;
						} else {
							answer += num[j] * count;
							count = 0;
						}
					} else {
						answer -= num[j];
						temp = num[j];
						count++;
					}
				}
				if (answer < 0) {
					sb.append(0).append("\n");
				} else
					sb.append(answer).append("\n");
			}
			br.close();
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
		} catch (Exception e) { //
			System.out.println(e.toString());
		}
	}
}