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
			int n = Integer.parseInt(br.readLine());
			for (int i = 1; i <= n; i++) {
				sb.append("#").append(i).append(" ");
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int[] A = new int[a];
				int[] B = new int[b];
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < a; j++) {
					A[j] = Integer.parseInt(st.nextToken());
				}
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < b; j++) {
					B[j] = Integer.parseInt(st.nextToken());
				}

				if (a > b) {
					int[] answer = new int[A.length - B.length + 1];
					for (int j = 0; j <= A.length - B.length; j++) {
						for (int v = 0; v < B.length; v++) {
							answer[j] += A[j + v] * B[v];
						}
					}
					int temp = 0;
					for (int j = 0; j < answer.length; j++) {
						if (temp < answer[j]) {
							temp = answer[j];
						}
					}
					sb.append(temp).append("\n");
				} else {
					int[] answer = new int[B.length - A.length + 1];
					for (int j = 0; j <= B.length - A.length; j++) {
						for (int v = 0; v < A.length; v++) {
							answer[j] += B[j + v] * A[v];
						}
					}
					int temp = 0;
					for (int j = 0; j < answer.length; j++) {
						if (temp < answer[j]) {
							temp = answer[j];
						}
					}
					sb.append(temp).append("\n");
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