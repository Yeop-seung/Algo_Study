import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		try {
			int a = Integer.parseInt(st.nextToken());
			int b = 0;
			int c = 0;
			if (1 <= a && a <= 1000000) {
				for(int i = 0;i<a;i++) {
					st = new StringTokenizer(br.readLine());
					b = Integer.parseInt(st.nextToken());
					c = Integer.parseInt(st.nextToken());
					if(1<=b&&1<=c&&b<=1000&&c<=1000)
					bw.write((b+c)+"\n");
				}
				bw.flush();
				bw.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}