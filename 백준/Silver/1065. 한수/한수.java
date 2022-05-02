import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int n = Integer.parseInt(br.readLine());
			String checknum = null;
			int temp = 0;
			int count = 0;

			String[] checknumarr = null;
			for (int i = 1; i <= n; i++) {
				checknum = Integer.toString(i);
				checknumarr = checknum.split("");

				if (checknumarr.length == 1)
					count++;
				else if (checknumarr.length == 2)
					count++;
				else {
					temp = Integer.parseInt(checknumarr[0]) - Integer.parseInt(checknumarr[1]);

					if (temp == Integer.parseInt(checknumarr[1]) - Integer.parseInt(checknumarr[2])) {
						count++;
					}
				}
			}
			sb.append(count);
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}