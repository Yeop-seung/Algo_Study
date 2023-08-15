import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int N, K;
    public static int[] A;
    public static boolean[] robot;

    public static void main(String[] args) throws IOException {
        init();

        sb.append(solve());
        br.close();
        System.out.println(sb);
    }

    private static int solve() {
        int ans = 0;
        while (count()) {
            ans++;
            turn();
            move();
            add();
        }
        return ans;
    }

    private static boolean count() {
        int cnt = 0;

        // K이상이면 종료
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                cnt++;
            if (cnt >= K)
                return false;
        }
        return true;
    }

    private static void add() {
        // 로봇 올리기
        if (A[0] > 0) {
            robot[0] = true;
            A[0]--;
        }
    }

    private static void move() {
        // 로봇 이동
        for (int i = N - 1; i > 0; i--) {
            if (robot[i - 1] && !robot[i] && A[i] >= 1) {
                robot[i] = true;
                robot[i - 1] = false;
                A[i]--;
            }
        }
    }

    private static void turn() {
        // 벨트 회전
        int temp = A[A.length - 1];
        for (int i = A.length - 1; i > 0; i--) {
            A[i] = A[i - 1];
        }
        A[0] = temp;

        // 로봇 회전
        for (int i = robot.length - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        // 마지막 로봇 내리기
        robot[N - 1] = false;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N * 2];
        robot = new boolean[N * 2];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}
