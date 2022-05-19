import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int m = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			int answer = 0, temp = n;
			boolean[] check = new boolean[n + 1];

			check[0] = true;
			check[1] = true;

			for (int i = 2; i <= Math.sqrt(check.length); i++) {
				for (int j = i * i; j < check.length; j += i) {
					check[j] = true;
				}
			}

			for (int i = m; i <= n; i++) {
				if (check[i] == false) {
					answer += i;
					if (temp == n) {
						temp = i;
					}
				}
			}

			if (answer == 0) {
				sb.append(-1);
			} else {
				sb.append(answer).append("\n").append(temp);
			}
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}