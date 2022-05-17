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

			st = new StringTokenizer(br.readLine());
			int count = 0;
			if (n <= 100) {
				for (int i = 0; i < n; i++) {
					int a = Integer.parseInt(st.nextToken());
					boolean check = true;

					if (a > 1 && a <= 1000) {
						for (int j = 2; j <= Math.sqrt(a); j++) {
							if (a % j == 0) {
								check = false;
								break;
							}
						}
						if (check)
							count++;
					}
				}

				sb.append(count);

				System.out.println(sb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}