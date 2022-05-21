import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		try {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			if (1 <= m && m <= n && n <= 1000000) {
				boolean[] result = prime(n);
				for (int i = m; i < result.length; i++) {
					if (result[i] == false) {
						sb.append(i).append("\n");
					}
				}
				System.out.println(sb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public static boolean[] prime(int n) {
		boolean[] primeNum = new boolean[n+1];
		primeNum[1] = true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (primeNum[i] == true) {
				continue;
			} else {
				for (int j = i * i; j < primeNum.length; j = j + i) {
					primeNum[j] = true;
				}
			}
		}
		return primeNum;
	}
}