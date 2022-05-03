import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		try {
			st = new StringTokenizer(br.readLine());

			int[] num = new int[2];
			String temp = null;

			for (int i = 0; i < num.length; i++) {
				temp = st.nextToken();
				String result = "";
				for (int j = temp.length() - 1; j >= 0; j--)
					result = result + temp.charAt(j);

				num[i] = Integer.parseInt(result);
			}
			if (num[0] > num[1])
				sb.append(num[0]);
			else
				sb.append(num[1]);

			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}