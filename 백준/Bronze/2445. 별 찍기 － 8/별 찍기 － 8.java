import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i < N; i++) {
			for (int j = N - i; j < N; j++) {
				sb.append("*");
			}
			for (int j = (i + 1) * 2; j <= (N * 2)+1; j++) {
				sb.append(" ");
			}
			for (int j = N - i; j < N; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		for (int i = 0; i < (N * 2); i++) {
			sb.append("*");
		}
		sb.append("\n");

		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N - 1; j++) {
				sb.append("*");
			}
			for (int j = 0; j < (i + 1) * 2; j++) {
				sb.append(" ");
			}
			for (int j = i; j < N - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		br.close();
		System.out.println(sb);
	}
}