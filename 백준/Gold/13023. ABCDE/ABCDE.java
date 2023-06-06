import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for (int i = 0; i < N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (dfs(i, 0)) flag = true;
        }

        if (flag) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean dfs(int num, int depth) {
        if (depth == 4)
            return true;

        visited[num] = true;
        for (int i = 0; i < list[num].size(); i++) {
            int temp = list[num].get(i);
            if (!visited[temp]) {
                visited[temp] = true;
                if (dfs(temp, depth + 1)) return true;
                visited[temp] = false;
            }
        }
        return false;
    }
}
