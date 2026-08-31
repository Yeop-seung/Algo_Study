import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int testcase = 1; testcase <= 10; testcase++) {
            int T = Integer.parseInt(br.readLine().trim());
            sb.append("#").append(T).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            while (st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));

            loop:
            while (true) {
                for (int i = 1; i <= 5; i++) {
                    int temp = list.pollFirst();
                    temp -= i;
                    if (temp > 0) list.addLast(temp);
                    else {
                        list.addLast(0);
                        break loop;
                    }
                }
            }
            
            sb.append(list.stream().map(String::valueOf).reduce((a, b) -> a + " " + b).orElse(""));
            sb.append("\n");
        }

        if (sb.length() > 0)
            sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}