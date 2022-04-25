import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			int a = 0;
			int count = 0;
			List<Integer> intArray = new ArrayList<Integer>();
			for (int i = 0; i < 10; i++) {
				st = new StringTokenizer(br.readLine());
				intArray.add(Integer.parseInt(st.nextToken()) % 42);
			}
			Collections.sort(intArray);
			if (intArray.get(0) == 0)
				count = 1;
			while (intArray.size() != 0) {
				if (intArray.get(0) == a) {
					intArray.remove(0);
				} else {
					a = intArray.get(0);
					count++;
				}
			}
			System.out.println(count);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}