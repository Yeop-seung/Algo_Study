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
			int t = Integer.parseInt(br.readLine());
			int r = 0;
			String[] s = null;

			for (int i = 0; i < t; i++) {
				st = new StringTokenizer(br.readLine());

				r = Integer.parseInt(st.nextToken());

				s = st.nextToken().split("");

				for (int j = 0; j < s.length; j++) {
					for (int v = 0; v < r; v++) {
						sb.append(s[j]);
					}
				}
				sb.append("\n");
			}

			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}