import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int temp = 0;

			int n = Integer.parseInt(br.readLine());

			String[] num = br.readLine().split("");

			for (int i = 0; i < n; i++) {
				temp += Integer.parseInt(num[i]);
			}
			sb.append(temp);

			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}