import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		while (!(queue.isEmpty())) {
			int num = 0;
			for (int i = 1; i < K; i++) {
				num = queue.poll();
				queue.offer(num);
			}
			num = queue.peek();
			if (queue.size() == 1)
				sb.append(num);
			else
				sb.append(num).append(", ");
			queue.poll();
		}
		sb.append(">");
		br.close();
		System.out.println(sb);
	}
}
