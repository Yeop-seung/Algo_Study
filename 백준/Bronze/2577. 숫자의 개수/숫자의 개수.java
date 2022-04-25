import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		try {
			int a = 1;
			int count;
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				a *= Integer.parseInt(st.nextToken());
			}
			String[] strArray = Integer.toString(a).split("");
			Arrays.sort(strArray);
			for (int i = 0; i <= 9; i++) {
				count = 0;
				for (int j = 0; j < strArray.length; j++) {
					if (i == Integer.parseInt(strArray[j])) {
						count++;
					}
				}
				if (i == 9)
					sb.append(count);
				else
					sb.append(count).append("\n");
			}
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}