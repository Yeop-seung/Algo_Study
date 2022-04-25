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

			double[] answer = new double[a];
			String[] strArray = new String[a];

			for (int i = 0; i < a; i++) {
				strArray[i] = br.readLine();
			}

			int[] student;
			int average, overcount;
			String result;

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(strArray[i], " ");
				student = new int[Integer.parseInt(st.nextToken())];
				average = 0;

				for (int j = 0; j < student.length; j++) {
					student[j] = Integer.parseInt(st.nextToken());
					average += student[j];
				}

				average /= student.length;
				overcount = 0;

				for (int v = 0; v < student.length; v++) {
					if (student[v] > average)
						overcount++;
				}

				answer[i] = (double) overcount / student.length * 100;
				result = String.format("%.3f", answer[i]);
				;
				if (i == a - 1)
					sb.append(result).append("%");
				else
					sb.append(result).append("%").append("\n");
			}

			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}