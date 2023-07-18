import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E;
	static int ans, cnt;
	static Edge[] edgeList;

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int[] p;

	private static void make() {
		p = new int[V];
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}
	}

	private static int find(int a) {
		if (a == p[a])
			return a;
		return p[a] = find(p[a]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		p[bRoot] = aRoot;
		return true;
	}

	private static void Kruskal() throws IOException {
		edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(from, to, weight);
		}

		Arrays.sort(edgeList);

		make();

		ans = 0;
		cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				ans += edge.weight;
				if (++cnt == V - 1)
					break;
			}
		}
	}

	static Node[] nodeList;

	static class Node {
		int vertex, weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

	}

	private static void Prim() throws IOException {
		nodeList = new Node[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			nodeList[from] = new Node(to, weight, nodeList[from]);
			nodeList[to] = new Node(from, weight, nodeList[to]);
		}
		int[] minEdge = new int[V];
		boolean[] visited = new boolean[V];

		Arrays.fill(minEdge, Integer.MAX_VALUE);

		minEdge[0] = 0;
		ans = 0;
		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;
			ans += min;

			for (Node temp = nodeList[minVertex]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
				}
			}
		}
	}

	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	private static void PrimPQ() throws IOException {
		nodeList = new Node[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			nodeList[from] = new Node(to, weight, nodeList[from]);
			nodeList[to] = new Node(from, weight, nodeList[to]);
		}
		int[] minEdge = new int[V];
		boolean[] visited = new boolean[V];

		Arrays.fill(minEdge, Integer.MAX_VALUE);

		minEdge[0] = 0;
		ans = 0;

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(0, minEdge[0]));

		int cnt = 0;
		while (true) {

			Vertex minVertex = pq.poll();
			if (visited[minVertex.no])
				continue;

			visited[minVertex.no] = true;
			ans += minVertex.weight;

			if (++cnt == V)
				break;
			for (Node temp = nodeList[minVertex.no]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
					pq.offer(new Vertex(temp.vertex, minEdge[temp.vertex]));
				}
			}
		}
	}

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

//		Kruskal();
//		Prim();
		PrimPQ();

		br.close();
		sb.append(ans);
		System.out.println(sb);
	}

}
