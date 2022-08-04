import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	static boolean[] isChecked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		isChecked = new boolean[N + 1];
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		loop(N, M, arr, 0, 0);

		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static void loop(int N, int M, int[] arr, int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			if (isChecked[i] == true)
				continue;
			numbers[cnt] = arr[i];
			isChecked[i] = true;
			loop(N, M, arr, cnt + 1, 0);
			isChecked[i] = false;

		}
	}
}
