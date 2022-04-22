import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		try {

			int a = Integer.parseInt(st.nextToken());
			if (1 <= a && a <= 10000) {
				int answer = 0;
				for (int i = 1; i <= a; i++) {
					answer += i;
				}
				System.out.println(answer);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}