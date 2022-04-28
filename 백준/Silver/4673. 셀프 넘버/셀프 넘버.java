import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		try {
			boolean check = true;
			int temp = 0;

			String[] arr = null;

			for (int i = 1; i <= 10000; i++) {
				check = true;
				if (i > 36) {
					for (int j = i - 36; j <= i; j++) {
						temp = j;
						arr = Integer.toString(j).split("");
						for (int v = 0; v < arr.length; v++) {
							temp += Integer.parseInt(arr[v]);

							if (temp > i) {
								break;
							}
						}
						if (i == temp) {
							check = false;
							break;
						}
					}
				} else {
					for (int j = 1; j <= i; j++) {
						temp = j;
						arr = Integer.toString(j).split("");
						for (int v = 0; v < arr.length; v++) {
							temp += Integer.parseInt(arr[v]);

							if (temp > i) {
								break;
							}
						}
						if (i == temp) {
							check = false;
							break;
						}
					}
				}
				if (check == true) {
					sb.append(i).append("\n");
				}
			}
			System.out.println(sb);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}