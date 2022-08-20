import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static List<Integer>[] list;
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		stack = new Stack<>();

		visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken()) - 1;
			int after = Integer.parseInt(st.nextToken()) - 1;

			list[before].add(after);
			list[after].add(before);
		}

		for (int i = 0; i < list.length; i++) {
			Collections.sort(list[i]);
		}
		stack.add(V);
		visited[V - 1] = true;
		dfs();
		sb.append("\n");
		Arrays.fill(visited, false);
		bfs();
		System.out.println(sb);
	}

	static Stack<Integer> stack;

	private static void dfs() {

		while (!stack.isEmpty()) {
			int num = stack.pop();

			visited[num - 1] = true;
			sb.append(num).append(" ");
			for (int i = 0; i < list[num - 1].size(); i++) {
				if (visited[list[num - 1].get(i)])
					continue;
				visited[list[num - 1].get(i)] = true;
				stack.push(list[num - 1].get(i) + 1);
				dfs();
			}

		}
	}

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();

		queue.offer(V);
		visited[V - 1] = true;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			visited[num - 1] = true;
			sb.append(num).append(" ");
			for (int i = 0; i < list[num - 1].size(); i++) {
				if (visited[list[num - 1].get(i)])
					continue;
				visited[list[num - 1].get(i)] = true;
				queue.offer(list[num - 1].get(i) + 1);
			}
		}
	}

}
