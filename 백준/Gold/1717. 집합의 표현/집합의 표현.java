import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int n, m;

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < m; i++)
            solve();

        br.close();
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        switch (num) {
            case 0:
                union(a, b);
                break;
            case 1:
                sb.append((isSameParent(a,b))?"YES":"NO").append("\n");
                break;
        }
    }
    // x와 y의 부모가 같은지 확인
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        }

        return false;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                arr[y] = x;
            } else {
                arr[x] = y;
            }
        }
    }

    private static int find(int x) {
        if (x == arr[x])
            return x;

        return arr[x] = find(arr[x]);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i = 1; i <= n; i++)
            arr[i] = i;
    }
}
