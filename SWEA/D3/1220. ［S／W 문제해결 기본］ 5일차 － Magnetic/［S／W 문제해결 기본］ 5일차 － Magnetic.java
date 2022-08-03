import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("data/swea_1220.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = 10; // Test Case
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine()); // 100
			int[][] arr = new int[100][100];
			int cnt = 0; // 교착 수

			for (int i = 0; i < arr.length; i++) { // 초기값 설정
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < arr.length; i++) { // y
				for (int j = 0; j < arr[i].length; j++) { // x
					if (arr[i][j] != 1) // 1이 아니면 넘어간다
						continue;
					int nMagnetic = i; // 1가 나오면 1의 y값 저장
					for (int j2 = i + 1; j2 < arr.length; j2++) {
						if (arr[j2][j] == 1) // 1일때 밑으로 내려가며 1이 나오면 break;
							break;
						if (arr[j2][j] == 2) {
							int sMagnetic = j2; // 2의 y값 저장
							while (true) { // 교착상태까지 진행
								if (nMagnetic < N - 1 && sMagnetic > 0 && arr[sMagnetic - 1][j] == 2
										&& arr[nMagnetic + 1][j] == 1) { // 교착상태
									cnt++;
									break;
								}
								nMagnetic--; // 1 내려가기
								sMagnetic++; // 2 올라가기
							}
							break;
						}
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}