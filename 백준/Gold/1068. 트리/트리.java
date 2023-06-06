import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N, remove;
    public static int ans = 0;
    public static ArrayList<Integer>[] list;
    public static ArrayList<Integer> checkList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];
        checkList = new ArrayList<>();
        for (int i = 0; i < N; i++)
            list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == -1) ;
            else list[temp].add(i);
        }

        remove = Integer.parseInt(br.readLine());

        dfs(remove);

        solve();
        br.close();
        sb.append(ans);
        System.out.println(sb);
    }

    private static void dfs(int num) {
        for (int i = 0; i < list[num].size(); i++) {
            if (list[num].size() == 0) return;
            int temp = list[num].get(i);
            dfs(temp);
        }
        checkList.add(num);
        list[num].clear();
    }

    private static void solve() {
        pass:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < checkList.size(); j++) {
                if (checkList.get(j) == i) continue pass;
            }
            if (list[i].contains(remove)) list[i].remove(list[i].indexOf(remove));
            if (list[i].size() == 0) ans++;
        }
    }
}
