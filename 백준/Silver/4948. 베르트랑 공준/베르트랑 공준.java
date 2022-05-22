import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			while (true) {
				int n = Integer.parseInt(br.readLine());
				if (n == 0) {
					sb.setLength(sb.length()-1);
					break;
				} else if (1 <= n && n <= 123456) {
					if (n == 1) {
						sb.append(1).append("\n");
					} else {
						boolean[] arr = prime(n);
						int count = 0;
						for (int i = 0; i < arr.length; i++) {
							if (arr[i] == false) {
								count++;
							}
						}
						sb.append(count).append("\n");
					}
				}
			}
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public static boolean[] prime(int n) {
		boolean[] primeNum = new boolean[2 * n + 1];

		for (int i = 2; i <= Math.sqrt(2 * n); i++) {
			if (primeNum[i] == true) {
				continue;
			} else {
				for (int j = i * i; j < primeNum.length; j = j + i) {
					primeNum[j] = true;
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			primeNum[i] = true;
		}

		return primeNum;
	}
}