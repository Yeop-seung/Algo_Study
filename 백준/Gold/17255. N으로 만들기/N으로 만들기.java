import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int ans;
    public static char[] N;
    public static Set<String> set;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N.length; i++) {
            solve(i, i, "" + N[i], "" + N[i]);
        }

        br.close();
        sb.append(set.size());
        System.out.println(sb);
    }

    private static void solve(int left, int right, String temp, String path) {
        if (left == 0 && right == N.length - 1) {
            set.add(path);
            return;
        }
        if (left - 1 >= 0)
            solve(left - 1, right, N[left - 1] + temp, path + N[left - 1] + temp);
        if (right + 1 <= N.length - 1)
            solve(left, right + 1, temp + N[right + 1], path + temp + N[right + 1]);
    }

    private static void init() throws IOException {
        String temp = br.readLine();
        N = new char[temp.length()];
        set = new HashSet<>();
        for (int i = 0; i < temp.length(); i++) {
            N[i] = temp.charAt(i);
        }
        ans = 0;
    }
}
