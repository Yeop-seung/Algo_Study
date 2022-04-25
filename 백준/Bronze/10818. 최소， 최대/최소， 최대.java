import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int[] lst = new int[a];
				st = new StringTokenizer(br.readLine());
				for(int i = 0;i<a;i++) {
					lst[i] = Integer.parseInt(st.nextToken());
				}
				Arrays.sort(lst);
				sb.append(lst[0]).append(" ").append(lst[a-1]);
				System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}