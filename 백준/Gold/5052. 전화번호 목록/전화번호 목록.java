import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int t, n;
    public static String[] num;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            init();

            solve();
        }
        br.close();
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static void solve() {
        HashMap<String, Integer> map = new HashMap<>();
        // 해쉬맵은 key 값 중복 X
        // 전화번호를 맵에 넣는다
        for (String temp :
                num)
            map.put(temp, 1);

        // 맵에 넣은 전화번호를 하나씩 꺼낸다
        for (String temp :
                num) {
            // 꺼낸 전화번호에서 한숫자씩 늘려간다
            for (int i = 1; i < temp.length(); i++) {
                String checkStr = temp.substring(0, i);
                // 맵 안에 있는지 체크 있으면 NO
                if(map.containsKey(checkStr)){
                    sb.append("NO").append("\n");
                    return;
                }
            }
        }
        // 없으면 YES
        sb.append("YES").append("\n");
        return;
    }

    private static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        num = new String[n];

        for (int i = 0; i < n; i++) {
            num[i] = br.readLine();
        }
    }
}
