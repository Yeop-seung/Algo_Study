import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] isSelected;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		arr = new int[9];
		isSelected = new boolean[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		subSet(0,0, 0, 100);
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static void subSet(int cnt,int start, int sum, int max) {
		if (cnt == 7 && sum == max) {
			for (int i = 0; i < arr.length; i++) {
				if (isSelected[i])
					sb.append(arr[i]).append("\n");
			}
			return;
		}
		for (int i = start; i < arr.length; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			subSet(cnt + 1,i+1, sum + arr[i], max);
			isSelected[i] = false;
		}
	}

}
