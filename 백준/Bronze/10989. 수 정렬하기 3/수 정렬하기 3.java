import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int n = Integer.parseInt(br.readLine());
			int[] num = new int[n];
			if (1 <= n && n <= 10000000) {
				for (int i = 0; i < n; i++) {
					num[i] = Integer.parseInt(br.readLine());
				}
				Arrays.sort(num);
				for (int i = 0; i < n; i++) {
					sb.append(num[i]).append("\n");
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