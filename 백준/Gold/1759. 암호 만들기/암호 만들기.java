import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static String[] str, ans;
	static boolean[] isSelected;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		isSelected = new boolean[C];

		ans = new String[L];
		str = br.readLine().split(" ");

		Arrays.sort(str);

		solve(0, 0);

		br.close();
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}

	private static void solve(int start, int cnt) {
		if (cnt == L) {
			if (check(ans)) {
				for (int i = 0; i < ans.length; i++) {
					sb.append(ans[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < str.length; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			ans[cnt] = str[i];
			solve(i + 1, cnt + 1);
			isSelected[i] = false;
		}
	}

	static String temp[] = { "a", "e", "i", "o", "u" };

	private static boolean check(String[] ans) {
		int cnt = 0;
		int otherCnt = 0;
		for (int i = 0; i < ans.length; i++) {
			boolean flag = false;
			for (int j = 0; j < temp.length; j++) {
				if (ans[i].equals(temp[j])) {
					flag = true;
					break;
				} else
					flag = false;
			}
			if (flag)
				++cnt;
			else
				++otherCnt;
		}
		if (cnt >= 1 && otherCnt >= 2)
			return true;
		return false;
	}
}
