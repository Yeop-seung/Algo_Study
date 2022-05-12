import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		try {
			int t = Integer.parseInt(br.readLine());
			for (int i = 0; i < t; i++) {
				st = new StringTokenizer(br.readLine());
				int h = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());

				int floor = n % h, room = n / h;
				
				if(floor==0) {
					sb.append(h*100+room).append("\n");
				}
				else
					sb.append(floor*100+room+1).append("\n");
			}
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}