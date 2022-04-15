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
			if (0 <= a && a <= 100) {
				if (90 <= a && a <= 100)
					System.out.println("A");
				else if (80 <= a && a < 90)
					System.out.println("B");
				else if (70 <= a && a < 80)
					System.out.println("C");
				else if (60 <= a && a < 70)
					System.out.println("D");
				else
					System.out.println("F");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}