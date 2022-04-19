import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		try {
			int a = Integer.parseInt(st.nextToken());
			int[] ia = new int[a];

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				ia[i]= b+c;
			}
			for(int i = 0;i<a;i++) {
				System.out.println(ia[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}