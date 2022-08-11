import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		arr = new int[N][2];
		isSelected = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		subSet(0, 1, 0);
		sb.append(min);

		br.close();
		System.out.println(sb);

	}

	public static void subSet(int cnt, int multiply, int add) {
		for (int i = 0; i < arr.length; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			subSet(cnt + 1, multiply * arr[i][0], add + arr[i][1]);
			isSelected[i] = false;
		}
		if (multiply != 1)
			min = Math.min(min, Math.abs(multiply - add));
		return;
	}
}
