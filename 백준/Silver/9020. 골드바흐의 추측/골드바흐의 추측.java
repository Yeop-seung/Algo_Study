import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 1; i <= t; i++) {
				int n = Integer.parseInt(br.readLine());

				if (4 <= n && n <= 10000) {
					List<Integer> result = Solution(n);
					int[] answer = new int[2];
					answer[0] = 0;
					answer[1] = Integer.MAX_VALUE;
					for (int j = 0; j < result.size() - 1; j++) {
						for (int v = j; v < result.size(); v++) {
							if (result.get(j) + result.get(v) == n) {
								if (result.get(v) - result.get(j) < answer[1] - answer[0]) {
									answer[0] = result.get(j);
									answer[1] = result.get(v);
								}
							}
						}
					}
					sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
				}
			}
			br.close();
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
		} catch (

		Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public static List<Integer> Solution(int n) {
		boolean[] prime = new boolean[n + 1];
		List<Integer> list = new ArrayList<Integer>();
		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (prime[i] == true)
				continue;
			for (int j = i * i; j < prime.length; j = j + i) {
				prime[j] = true;
			}
		}
		for (int i = 0; i < prime.length; i++) {
			if (prime[i] == false) {
				list.add(i);
			}
		}
		return list;
	}
}