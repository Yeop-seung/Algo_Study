import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int n = Integer.parseInt(br.readLine());

			if (n == 1) {
				return;
			}
			if (2 <= n && n <= 10000000) {
				int temp = n;
				while (true) {
					for (int i = 2; i <= n; i++) {
						if (temp % i == 0) {
							temp /= i;
							sb.append(i).append("\n");
							break;
						}
					}
					if (temp == 1)
						break;
				}
			}
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}