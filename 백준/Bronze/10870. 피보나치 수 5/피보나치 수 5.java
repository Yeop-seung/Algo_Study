import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int n = Integer.parseInt(br.readLine());

			int result = Solution(n);

			sb.append(result);
			br.close();
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public static int Solution(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;

		return Solution(n - 1) + Solution(n - 2);
	}
}