import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int N, d, k, c;
    public static int cnt, ans;
    public static int[] arr, dArr;


    public static void main(String[] args) throws IOException {
        init();

        solve();

        sb.append(ans);
        br.close();
        System.out.println(sb);
    }

    private static void solve() {
        // arr = [7,9,7,30,2,7,9,25] = 회전초밥
        // dArr[30] = 각 인덱스는 초밥 번호로 초밥을 먹은 횟수

        // 이렇게 있을때 먼저 첫번째 부터 k번 째인 4번째 까지 가짓수를 센다
        for (int i = 0; i < k; i++)
            // arr[i]번 째에 있는 숫자가 0이면 가짓수(cnt)를 더한다
            // 중복된 초밥이 나왔을경우 0이 아니라 가짓수는 올라가지 않지만
            // arr[i](초밥번호)에 대한 먹은 횟수는 ++연산을 통해 올라간다.
            if (dArr[arr[i]]++ == 0) cnt++;

        // start를 i로 잡고 한칸씩 뒤로 가며 정답 계산
        for (int i = 0; i < N; i++) {
            
            if (ans <= cnt) {   // 처음은 무조건 가짓수가 더 적어서 들어간다
                                // 이 후부터는 정답보다 가짓수(cnt)가 더 많아지면 들어옴
                
                // 쿠폰을 안먹었다면 가짓수+1을 ans 에 저장
                if (dArr[c] == 0) ans = cnt + 1;
                // 아니라면 가짓수 저장 
                else ans = cnt;
            }
            // i는 start 이고 j는 end
            int j = (i + k) % N;
            // arr[j]에 있는걸 먹으며 먹은적 없으면 cnt증가
            if (dArr[arr[j]]++ == 0) cnt++;
            // 첫번째로 먹은 초밥을 빼주고 뺀 후에 접시가 비었다면 가짓수또한 하나 빼준다.
            if (--dArr[arr[i]] == 0) cnt--;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        cnt = 0;
        ans = 0;

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dArr = new int[d + 1];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
    }
}
