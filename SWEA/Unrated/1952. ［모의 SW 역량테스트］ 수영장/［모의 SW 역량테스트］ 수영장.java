import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] price, plan;
	static int[] dp = new int[13]; // 0 dummy
	static int min;
	static Queue<Node> queue = new ArrayDeque<>();

	// dp 는 memoization 의 한 방법으로 점화식과 같은 신뢰할 수 있는 (검증된) 식으로 단계별로 다음 값을 계산해 가는 방식
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			price = new int[3];

			for (int i = 0; i < price.length; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.parseInt(st.nextToken());
			plan = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < plan.length; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			// 완탐 dfs
			// 1년 치 제외한 3가지 사용료 방법을 모두 따지는 방식 진행 각각 min 갱신
			// dfs() 끝나고 나면 min에 가장 작은 값이 들어가 있음. => 마지막으로 1년치 비용과 비교 최소값

//			dfs(0, 0); // 최초, 비용 0

			// 완탐 bfs
			// 최초 시점의 Node 를 하나 queue 에 담고 시작
//			queue.offer(new Node(0, 0));
//			bfs();

			// dp
			dp[0] = 0;
			dp[1] = Math.min(plan[1] * price[0], price[1]); // 일계산과 월계산 중 비용이 적은 것 선택
			dp[2] = Math.min(dp[1] + plan[2] * price[0], dp[1] + price[1]); // 누적
			// dp[3]
			for (int i = 3; i <= 12; i++) {
				dp[i] = min(dp[i - 1] + plan[i] * price[0], dp[i - 1] + price[1], dp[i - 3] + price[2]);
			}

			// dp[12] <= 1일, 1달, 3달 에 대한 최소값 계산
			// dp[12], min 중 최소값 선택
			min = Math.min(min, dp[12]);
			sb.append(min).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	static class Node {
		int cnt, sum;

		public Node(int cnt, int sum) {
			this.cnt = cnt;
			this.sum = sum;
		}
	}

	// 재귀 호출방식 => 파라미터로 어떤 값을 가지고 계속 이어갈 것인가?
	private static void dfs(int cnt, int sum) {
		// 기저 조건
		if (cnt >= 12) {
			min = Math.min(sum, min);
			return;
		}
		// 계속 따져간다.
		// 이용하지 않는 월에 대한 처리
		if (plan[cnt] == 0) {
			dfs(cnt + 1, sum);
		} else {
			// cnt + 1 번째 달에 대해
			// 1. 일 계산
			int cost = plan[cnt] * price[0];
			if (sum + cost < min)
				dfs(cnt + 1, sum + cost);
			// 2. 월 계산
			if (sum + price[1] < min)
				dfs(cnt + 1, sum + price[1]);
			// 3. 3개월 계산
			if (sum + price[2] < min)
				dfs(cnt + 3, sum + price[2]);
		}
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			// 꺼내어서 다음 단계를 따진다.
			Node node = queue.poll();
			int cnt = node.cnt;
			int sum = node.sum;

			// 기저 조건
			if (cnt >= 12) {
				min = Math.min(sum, min);
				continue; // 현재 12월에 도달한 Node는 min 을 따지고 이하 더 계속 방문 X
			}
			// 계속 따져간다.
			// 이용하지 않는 월에 대한 처리
			if (plan[cnt] == 0) {
				queue.offer(new Node(cnt + 1, sum));
			} else {
				// cnt + 1 번째 달에 대해
				// 1. 일 계산
				queue.offer(new Node(cnt + 1, sum + (plan[cnt] * price[0])));
				// 2. 월 계산
				queue.offer(new Node(cnt + 1, sum + price[1]));
				// 3. 3개월 계산
				queue.offer(new Node(cnt + 3, sum + price[2]));
			}
		}
	}

}
