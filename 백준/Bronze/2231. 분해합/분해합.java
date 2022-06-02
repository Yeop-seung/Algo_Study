import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int n = Integer.parseInt(br.readLine());
			if (1 <= n && n <= 1000000) {
				int result = Solution(n);
				sb.append(result);
			}
			br.close();
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public static int Solution(int n) {
		for (int i = 1; i <= n; i++) {
			int temp = i;
			int sum = 0;
			while (temp != 0) {
				sum += temp % 10;
				temp /= 10;
			}
			if (n == i + sum)
				return i;
		}
		return 0;
	}
}