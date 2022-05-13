import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int n = Integer.parseInt(br.readLine());

			int five = 0;
			int three = 0;

			int result = 0;

			if (n == 3)
				result = 1;
			else if (n >= 5) {
				five = n / 5;
				three = n % 5 / 3;

				while (true) {
					if (five * 5 + three * 3 == n) {
						result = five + three;
						break;
					} else if (five * 5 + three * 3 < n) {
						three++;
					} else if (five == 0) {
						result = -1;
						break;
					} else if (five * 5 + three * 3 > n) {
						five--;
					}
				}
			} else
				result = -1;
			
			sb.append(result);

			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}