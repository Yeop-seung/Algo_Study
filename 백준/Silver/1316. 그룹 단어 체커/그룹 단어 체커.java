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
			String word = "";

			boolean[] check;
			boolean pass;

			int index = 0;
			int count = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				word = st.nextToken();

				check = new boolean[26];
				pass = true;

				for (int j = 0; j < word.length(); j++) {
					index = word.charAt(j) - 'a';
					if (check[index]) {
						if (word.charAt(j) != word.charAt(j - 1)) {
							pass = false;
							break;
						}
					} else
						check[index] = true;
				}
				if (pass)
					count++;
			}
			sb.append(count);
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}