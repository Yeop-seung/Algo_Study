import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int answer = 0;

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] num = { a, b, c };

		Arrays.sort(num);

		if (num[0] == num[1] && num[1] == num[2]) {
			answer = 10000 + num[2] * 1000;
		} else if (num[0] == num[1] || num[1] == num[2] || num[0] == num[2]) {
			if (num[0] == num[1]) {
				answer = 1000 + num[0] * 100;
			} else if (num[1] == num[2]) {
				answer = 1000 + num[1] * 100;
			} else if (num[0] == num[2]) {
				answer = 1000 + num[0] * 100;
			}
		} else
			answer = num[2] * 100;

		System.out.println(answer);
	}
}
