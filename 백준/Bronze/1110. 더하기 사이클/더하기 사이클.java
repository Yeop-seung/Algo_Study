import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String answer = st.nextToken();
		String temp = answer;
		int result = 0;
		if(Integer.parseInt(answer) < 10) {
			answer = "0"+answer;
			temp = answer;
		}
		
		boolean check = true;
		int a = Character.getNumericValue(answer.charAt(0));
		int b = Character.getNumericValue(answer.charAt(1));
		while(check) {
			
			answer = String.valueOf(a+b);
			if(Integer.parseInt(answer) < 10) {
				answer = "0"+answer;
			}
			a = b;
			b= Character.getNumericValue(answer.charAt(1));
			
			answer = a+""+b;
			result++;
			if(answer.equals(temp)) {
				check = false;
			}
		}
		System.out.println(result);
		
	}
}