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
			String word = br.readLine();

			int temp = word.length();
			String[][] dial = new String[][] { { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" },
					{ "J", "K", "L" }, { "M", "N", "O" }, { "P", "Q", "R", "S" }, { "T", "U", "V" },
					{ "W", "X", "Y", "Z" } };
			int[][] num = new int[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 }, { 0 } };

			for (int i = 0; i < word.length(); i++) {
				for (int j = 0; j < dial.length; j++) {
					for (int v = 0; v < dial[j].length; v++) {
						if (word.charAt(i) == dial[j][v].charAt(0)) {
							temp += j+2;
						}
					}
				}
			}
			sb.append(temp);
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}