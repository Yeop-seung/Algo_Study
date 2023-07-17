import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static long N, num;

    public static void main(String[] args) throws IOException {
        init();

        solve();

        System.out.println(sb);
    }

    private static void solve() {
        num = 1;

        for (int i = 2; i <= N; i++) {
            // N이 커지면 터지므로 곱할때 나머지를 구해서 곱한다
            // 어차피 앞에는 필요가 없다
            num *= i;
            num %= 1000000000;

            // 첫번 째 자리가 0이면 자리를 땡겨준다
            while (num % 10 == 0) num /= 10;
        }

        // 첫번 째 자리 반환
        sb.append(num % 10);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}
