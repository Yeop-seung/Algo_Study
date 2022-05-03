import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			String word = br.readLine();

			String[] change = new String[] { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

			for (int i = 0; i < change.length; i++) {
				word = word.replaceAll(change[i], "a");
			}
			sb.append(word.length());
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}