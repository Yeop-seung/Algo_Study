import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int[] alphabet = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
					22, 23, 24, 25 };
			int[] answer = new int[26];
			Arrays.fill(answer, -1);
			
			String[] input = br.readLine().split("");
			for (int i = 0; i < alphabet.length; i++) {
				for (int j = 0; j < input.length; j++) {
					if (alphabet[i] == (int) input[j].charAt(0) - (int) 'a') {
						answer[i] = j;
						break;
					}
				}
			}

			for (int i = 0; i < answer.length; i++) {
				if (i == answer.length - 1)
					sb.append(answer[i]);
				else
					sb.append(answer[i]).append(" ");
			}

			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}