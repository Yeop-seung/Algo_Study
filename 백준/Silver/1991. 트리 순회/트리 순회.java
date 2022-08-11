import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb;
	static char[][] arr;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new char[N + 1][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int index = (int) (st.nextToken().charAt(0) - 'A');
			arr[index][0] = st.nextToken().charAt(0);
			arr[index][1] = st.nextToken().charAt(0);
		}

		dfsByPreOrder('A');
		sb.append("\n");
		dfsByInOrder('A');
		sb.append("\n");
		dfsByPostOrder('A');

		br.close();
		System.out.println(sb);
	}

	private static void dfsByPreOrder(char c) {
		if (c == '.')
			return;
		sb.append(c);
		dfsByPreOrder(arr[c - 'A'][0]);
		dfsByPreOrder(arr[c - 'A'][1]);
	}

	private static void dfsByInOrder(char c) {
		if (c == '.')
			return;
		dfsByInOrder(arr[c - 'A'][0]);
		sb.append(c);
		dfsByInOrder(arr[c - 'A'][1]);
	}

	private static void dfsByPostOrder(char c) {
		if (c == '.')
			return;
		dfsByPostOrder(arr[c - 'A'][0]);
		dfsByPostOrder(arr[c - 'A'][1]);
		sb.append(c);
	}

}
