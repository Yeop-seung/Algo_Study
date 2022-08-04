import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static Queue<Integer> queue;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		queue = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		loop();
	}

	public static void loop() {
		if (queue.size() == 1) {
			System.out.println(queue.poll());
			return;
		}
		queue.poll();
		int num = queue.poll();
		queue.offer(num);
		loop();
	}
}
