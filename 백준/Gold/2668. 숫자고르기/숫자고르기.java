import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int N;
    public static int[] num;
    public static boolean[] check;
    public static ArrayList<Integer> ans;


    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= N; i++) {
            check[i] = true;
            solve(i, i);
            check[i] = false;
        }

        Collections.sort(ans);
        sb.append(ans.size()).append("\n");
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append("\n");
        }

        br.close();
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static void solve(int start, int end) {
        if (check[num[start]] == false) {
            check[num[start]] = true;
            solve(num[start], end);
            check[num[start]] = false;
        }
        if (num[start] == end) ans.add(end);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        num = new int[N + 1];
        check = new boolean[N + 1];
        ans = new ArrayList<>();

        for (int i = 1; i <= N; i++)
            num[i] = Integer.parseInt(br.readLine());
    }
}
