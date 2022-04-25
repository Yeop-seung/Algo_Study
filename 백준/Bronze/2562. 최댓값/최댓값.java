import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		try {
			int count = 0;
			int num = 0;
			int[] lst = new int[9];
				for(int i = 0;i<lst.length;i++) {
					st = new StringTokenizer(br.readLine());
					lst[i] = Integer.parseInt(st.nextToken());
					if(num < lst[i]) {
						count = i+1;
						num = lst[i];
					}
				}
				sb.append(num).append("\n").append(count);
				System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}