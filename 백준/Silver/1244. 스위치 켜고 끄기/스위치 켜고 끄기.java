import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 스위치 입력
		}

		int num = Integer.parseInt(br.readLine()); // 학생의 수
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken()); // 학생 성별
			int swc = Integer.parseInt(st.nextToken()); // 학생의 스위치 위치

			if (student == 1) { // 남자일 때 스위치 변경
				for (int j = swc; j < arr.length; j += swc) {
					arr[j] = Math.abs(arr[j] - 1);
				}
			} else { // 여자일 때 스위치 변경
				int idx = 0;
				int left = swc + idx * -1;
				int right = swc + idx;
				while (left >= 1 && right <= N && arr[left] == arr[right]) {
					if (left == right)
						arr[left] = Math.abs(arr[left] - 1);
					else {
						arr[left] = Math.abs(arr[left] - 1);
						arr[right] = Math.abs(arr[right] - 1);
					}
					++idx;
					left = swc + idx * -1;
					right = swc + idx;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (i % 20 == 0) {
				sb.append(arr[i]).append("\n");
			} else {
				sb.append(arr[i]).append(" ");
			}
		}
		br.close();
		System.out.println(sb);
	}
}