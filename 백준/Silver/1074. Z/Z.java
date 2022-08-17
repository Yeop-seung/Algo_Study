import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		solve((int) Math.pow(2, sc.nextInt()), sc.nextInt(), sc.nextInt());
		System.out.println(ans);
	}

	static int ans;

	private static void solve(int n, int r, int c) {
		if (n == 2) {
			if (r == 0 && c == 1) // 2사분면
				ans += 1;
			else if (r == 1 && c == 0) // 3사분면
				ans += 2;
			else if (r == 1 && c == 1) // 4사분면
				ans += 3;

			return;
		}
		int half = n / 2;

		int skip = 3; // 기본은 4사분면에 있다고 가정
		if (r < half && c < half) // 1사분면
			skip = 0;
		else if (r < half && c >= half) // 2사분면
			skip = 1;
		else if (r >= half && c < half) // 3사분면
			skip = 2;

		ans += half * half * skip;

		solve(half, r % half, c % half);
	}
}