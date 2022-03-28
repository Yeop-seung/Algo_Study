import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 자동 생성된 메소드 스텁
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = 0;
		int b = 0;
		int c = 0;

		Boolean check = true;
		while (check) {
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());

			if (a >= 0 && a < 24 && b >= 0 && b < 60 && c >= 0 && c <= 1000) {
				check = false;
			} else {
				check = true;
				System.out.println("입력오류");
			}
		}

		if (b + c >= 60) {
			int temp = 0;
			temp = (b+c)/60;
			b=(b+c)%60;
			if(a + temp >= 24) {
				temp = (a+temp)%24;
				a = 0+temp;
			}
			else {
				a+=temp;
			}
		} else {
			b += c;
		}

		System.out.println(a + " " + b);
	}

}
