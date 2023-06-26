import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        String temp = br.readLine();

        stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            int cnt = 0;
            stack.push(str.charAt(i));

            if (stack.size() >= temp.length()) {

                for (int j = 0; j < temp.length(); j++) {

                    if (stack.get(stack.size() - temp.length() + j) == temp.charAt(j)) {
                        cnt++;
                    }

                    if (cnt == temp.length()) {
                        for (int k = 0; k < temp.length(); k++) {
                            stack.pop();
                        }
                    }

                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char ch : stack) {
                sb.append(ch);
            }

        }
        br.close();
        System.out.println(sb);
    }
}
