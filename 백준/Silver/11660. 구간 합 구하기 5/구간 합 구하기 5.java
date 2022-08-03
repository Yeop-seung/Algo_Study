import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/boj_11660_2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

//		  N : 표의 크기
//		  M : 합을 구해야 하는 횟수
//		  1 <= N <= 1024
//		  1 <= M <= 100,000

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
			} // 한줄씩 입력과 동시에 합하여 배열에 저장
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int sum = 0; // 총 더한 값
			int y1, x1, y2, x2; // 더해지는 범위의 x,y 좌표

			y1 = Integer.parseInt(st.nextToken());
			x1 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());

			for (int j = 0; j <= y2 - y1; j++) { // 0 <= y2-y1까지가 더하는 범위의 높이
				sum += arr[y1 + j][x2] - arr[y1 + j][x1 - 1]; // x2 - (x1-1) -> x1 부터 x2까지의 합
			}
			sb.append(sum).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
