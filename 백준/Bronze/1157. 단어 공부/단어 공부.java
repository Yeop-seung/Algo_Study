import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		try {
			String alphabet = br.readLine().toLowerCase();

			int[] check = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
					23, 24, 25 };
			int[] result = new int[26];
			int[] temp = new int[2];

			String[] s = null;
			s = alphabet.split("");

			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < check.length; j++) {
					if ((int) s[i].charAt(0) - (int) 'a' == check[j]) {
						result[j]++;
						break;
					}
				}
			}
			for (int i = 0; i < result.length; i++) {
				if (result[i] > temp[0]) {
					temp[0] = result[i];
					temp[1] = i;
				}
			}

			Arrays.sort(result);

			if (result[24] == result[25]) {
				sb.append("?");
			} else
				sb.append((char) (check[temp[1]] + (int) 'A'));

			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}