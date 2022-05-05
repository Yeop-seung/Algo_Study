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

			int n = Integer.parseInt(st.nextToken());
			int num = 1;
			int i = 1;
			if (n == 1)
				sb.append(1);
			else {
				while (true) {
					if (n <= num) {
						sb.append(i);
						break;
					} else
						num += 6 * i++;
				}
			}
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}