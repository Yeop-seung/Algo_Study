import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int c = 0;
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		String answer = "";
		for (int i = 0; i < n; i++) {
			c = Integer.parseInt(st.nextToken());
			if (c < x) {
				answer += c + " ";
			}
		}
		System.out.println(answer);
	}
}
