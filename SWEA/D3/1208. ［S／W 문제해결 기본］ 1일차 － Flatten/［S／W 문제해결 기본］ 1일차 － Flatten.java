import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[100];

			for (int j = 0; j < 100; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for (int j = 0; j < N; j++) {
				int loopNum = 0;
				arr[99] -= 1;
				arr[0] += 1;
				while (arr[loopNum] > arr[loopNum + 1] && loopNum < 100) {
					int temp = arr[loopNum];
					arr[loopNum] = arr[loopNum + 1];
					arr[loopNum + 1] = temp;
					loopNum++;
				}
				loopNum = 1;
				while (arr[100 - loopNum] < arr[100 - (loopNum + 1)] && loopNum < 100) {
					int temp = arr[100 - loopNum];
					arr[100 - loopNum] = arr[100 - (loopNum + 1)];
					arr[100 - (loopNum + 1)] = temp;
					loopNum++;
				}
				loopNum = 1;
			}
			sb.append(arr[99] - arr[0]).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}