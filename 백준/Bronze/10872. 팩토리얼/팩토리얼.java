import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int n = Integer.parseInt(br.readLine());

			int result = factory(n);

			sb.append(result);
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public static int factory(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} //
		else {
			return n * factory(n - 1);
		}
	}
}