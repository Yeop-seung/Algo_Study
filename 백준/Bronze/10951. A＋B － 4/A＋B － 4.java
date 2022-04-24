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
		try {
			int b, c = 0;
			while (true) {
				st = new StringTokenizer(br.readLine());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				bw.write((b + c) + "\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			bw.flush();
			bw.close();
		}
	}
}