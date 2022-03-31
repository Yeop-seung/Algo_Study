import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		String answer = "";

		for (int i = 1; i <= a; i++) {
			answer = "";
			for (int j = 0; j < a - i; j++) {
				answer += " ";
			}
			for (int v = 0; v < i; v++) {
				answer += "*";
			}
			System.out.println(answer);
		}
	}
}