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
			int b = Integer.parseInt(st.nextToken());
			if (-10000 <= a && -10000 <= b && a <= 10000 && b <= 10000) {
				if (a > b)
					System.out.println(">");
				else if (a == b)
					System.out.println("==");
				else
					System.out.println("<");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}