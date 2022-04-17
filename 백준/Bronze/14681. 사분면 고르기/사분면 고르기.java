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
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			if (-1000 <= a && a <= 1000 && -1000 <= b && b <= 1000) {
				if (a==0&&b==0)
					System.out.println("0");
				else if (a >0 && b> 0)
					System.out.println("1");
				else if(a<0&&b>0)
					System.out.println("2");
				else if(a<0&&b<0)
					System.out.println("3");
				else
					System.out.println("4");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}