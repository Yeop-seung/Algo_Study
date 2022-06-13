import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int n = Integer.parseInt(br.readLine());

			List<Integer> result = new ArrayList<Integer>();
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				if (i == 665) {
					continue;
				}
				if (result.size() == n)
					break;
				else {
					int temp = reverse(i);
					int count = 0;
					while (temp > 0) {
						if (temp % 10 == 6) {
							count++;
							temp /= 10;
						} //
						else {
							count = 0;
							temp /= 10;
						}
						if (count >= 3) {
							result.add(i);
							break;
						}
					}
				}
			}
			sb.append(result.get(n - 1));
			br.close();
			System.out.println(sb);
		} catch (Exception e) { //
			System.out.println(e.toString());
		}
	}

	public static int reverse(int x) {
		long res = 0;

		while (x != 0) {
			res *= 10;
			res += x % 10;
			x /= 10;
		}

		if (-Integer.MAX_VALUE <= res && res <= Integer.MAX_VALUE) {
			return (int) res;
		} else {
			return 0;
		}
	}
}