import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while (!(stack.isEmpty())) {
				if (stack.peek()[0] < num)
					stack.pop();
				else {
					sb.append(stack.peek()[1]).append(" ");
					break;
				}
			}
			if (stack.isEmpty()) {
				sb.append("0").append(" ");
			}
			stack.push(new int[] { num, i + 1 });
		}
		br.close();
		System.out.println(sb);
	}

}
