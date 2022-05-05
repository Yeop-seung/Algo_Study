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
			int n = Integer.parseInt(br.readLine());
			int i = 1, num = 0;
			if (1 <= n && n < 100000000) {
				while (true) {
					if (n <= num + i) {
						if (i % 2 == 1) {
							System.out.print((i - (n - num - 1)) + "/" + (n - num));
							break;
						}
						else {
							System.out.print((n - num) + "/" + (i - (n - num - 1)));
							break;
						}
					} else {
						num += i;
						i++;
					}
				}
				System.out.println(sb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}