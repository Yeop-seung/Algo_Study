import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int N, min;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        init();

        solve();

        print();
    }

    private static void print() throws IOException {
        br.close();
        System.out.println(sb);
    }


    private static void solve() {
        int left = 0;
        int right = N - 1;
        int minL = 0;
        int minR = 0;

        while (left < right) {
            int temp = arr[left] + arr[right];
            if (min > Math.abs(temp)) {
                min = Math.abs(temp);
                minL = left;
                minR = right;
            }
            if (temp >= 0) {
                right--;
            } else left++;
        }
        sb.append(arr[minL]).append(" ").append(arr[minR]);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
