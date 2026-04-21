import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		String[] filename = new String[N];
		String ans = new String();
		boolean check = true;
		for (int i = 0; i < N; i++) {
			filename[i] = sc.next();
		}
		for (int i = 0; i < filename[0].length(); i++) {
			for (int j = 0; j < N - 1; j++) {
				if (filename[j].charAt(i) != filename[j + 1].charAt(i)) {
					check = false;
					break;
				} else {
					check = true;
				}
			}
			if (check) {
				sb.append(filename[0].charAt(i));
			} else {
				sb.append("?");
			}
		}
		ans = sb.toString();
		System.out.println(ans);
	}
}
