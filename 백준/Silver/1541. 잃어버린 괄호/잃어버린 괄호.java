import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split("-");

		int ans = 0;
		for (int i = 0; i < temp.length; i++) {
			String[] sum = temp[i].split("\\+");
			if (i == 0) {
				for (int j = 0; j < sum.length; j++) {
					ans += Integer.parseInt(sum[j]);
				}
			} else {
				for (int j = 0; j < sum.length; j++) {
					ans -= Integer.parseInt(sum[j]);
				}
			}
		}
		System.out.println(ans);

	}
}
