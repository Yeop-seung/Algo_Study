import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int V, E;

	static Node[] nodeList;

	static class Node implements Comparable<Node> {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine()) - 1;

		nodeList = new Node[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			nodeList[from] = new Node(to, weight, nodeList[from]);
		}

		int[] minEdge = new int[V];
		boolean[] visited = new boolean[V];

		Arrays.fill(minEdge, Integer.MAX_VALUE);

		minEdge[start] = 0;
		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}

			if (minVertex == -1)
				continue;
			visited[minVertex] = true;

			for (Node temp = nodeList[minVertex]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > minEdge[minVertex] + temp.weight) {
					minEdge[temp.vertex] = minEdge[minVertex] + temp.weight;
				}
			}
		}

		for (int i = 0; i < minEdge.length; i++) {
			if (minEdge[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else {
				sb.append(minEdge[i]).append("\n");
			}
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

}
