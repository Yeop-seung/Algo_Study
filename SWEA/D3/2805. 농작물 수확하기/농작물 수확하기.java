import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // Test Case

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine()); // 농장 크기
			int sum = 0; // 가치 합
			int[][] arr = new int[N][N];
			for (int i = 0; i < arr.length; i++) { // 농장 가치 저장
				String num = br.readLine();
				for (int j = 0; j < arr[i].length; j++) { // String num을 한글자씩 변환하여 저장
					arr[i][j] = Character.getNumericValue(num.charAt(j));
				}
			}
			int count = N; // 반복 횟수 : (N미만 홀수값*2)+N
			for (int i = 0; i < N; i++) {
				if (i % 2 == 1)
					count += i * 2;
			}
			int y = 0; // y축 인덱스
			int x = N / 2; // x축 인덱스
			for (int i = 0; i < count; i++) {
				if (y == N / 2) { // 중간줄 일때
					for (int j = 0; j <= x; j++) {
						sum += arr[y][j];
					}
					y++;
					x--;
				} else if (y < N / 2) { // 첫번 째 줄에서 중간줄 까지
					for (int j = N - 1 - x; j <= x; j++) {
						sum += arr[y][j];
					}
					y++;
					x++;
				} else if (y > N / 2) { // 중간줄에서 끝줄까지 값
					for (int j = N - 1 - x; j <= x; j++) {
						sum += arr[y][j];
					}
					y++;
					x--;
				}
			}
			sb.append(sum).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
