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
			
			for(int i = 1; i<=9;i++) {
				System.out.printf("%d * "+i+" = %d\n",a,a*i);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}