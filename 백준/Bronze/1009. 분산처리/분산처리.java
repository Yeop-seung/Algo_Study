import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int a = 0;
		int b = 0;
		int n = 0;
		for (int i = 0; i < T; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			n = 1;
			for (int j = 0; j < b; j++) {
				n = n * a % 10;
			}
			if (n == 0 ) {
				System.out.println(10);
			} else {
				System.out.println(n);
			}
		}
	}
}