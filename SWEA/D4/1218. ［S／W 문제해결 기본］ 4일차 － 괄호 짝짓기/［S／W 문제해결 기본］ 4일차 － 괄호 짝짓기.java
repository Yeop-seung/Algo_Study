import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/swea_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean sameCheck = false;
			out: for (int i = 0; i < N; i++) {
				if (sameCheck == true)
					break;
				char check = str.charAt(i);
				if (check == '(' || check == '{' || check == '[' || check == '<') {
					stack.push(check);
				} else {
					switch (stack.pop()) {
					case '(':
						if (check != ')') {
							sameCheck = true;
							break out;
						}
						break;
					case '{':
						if (check != '}') {
							sameCheck = true;
							break out;
						}
						break;
					case '[':
						if (check != ']') {
							sameCheck = true;
							break out;
						}
						break;
					case '<':
						if (check != '>') {
							sameCheck = true;
							break out;
						}
						break;
					}
				}
			}
			if (sameCheck)
				sb.append(0).append("\n");
			else
				sb.append(1).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}