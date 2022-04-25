import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		try {
			int a = 0;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());

			String[] strArray = new String[a];
			String[] solve;
			int[] answer = new int[a];
			int score;

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				strArray[i] = st.nextToken();
			}
			for (int i = 0; i < a; i++) {
				score = 1;
				solve = strArray[i].split("");
				for (int j = 0; j < solve.length; j++) {
					if (solve[j].equals("O")) {
						answer[i] += score;
						score++;
					} else if (solve[j].equals("X")) {
						score = 1;
					}
				}
				if (i == a - 1)
					sb.append(answer[i]);
				else
					sb.append(answer[i]).append("\n");
			}
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}