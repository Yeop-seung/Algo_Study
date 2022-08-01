import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");

			st = new StringTokenizer(br.readLine());

			String num = st.nextToken();
			int[] arr = new int[num.length()];
			int cnt = 0;
			for (int i = 0; i < num.length(); i++) {
				if (Character.getNumericValue(num.charAt(i)) == arr[i]) {
					continue;
				} else {
					++cnt;
					for (int j = i; j < arr.length; j++) {
						arr[j] = Math.abs(arr[j] - 1);
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
