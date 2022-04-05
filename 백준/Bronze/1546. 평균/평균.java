import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		double temp = 0;
		
		double[] num = new double[n];
		for(int i = 0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		for(int j=0;j<n;j++) {
			num[j] = num[j]/num[n-1]*100;
			temp +=num[j];
		}
		temp /=n;
		System.out.println(temp);
	}
}