import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int N, M, ans;
    public static int start, end;
    public static ArrayList<ArrayList<Bus>> list;
    public static int[] dist;
    public static boolean[] visited;

    static class Bus implements Comparable<Bus> {
        int end;
        int value;

        public Bus(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Bus o) {
            return value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solve(start, end);

        sb.append(ans);
        System.out.println(ans);
    }

    private static void solve(int start, int end) {
        PriorityQueue<Bus> pq = new PriorityQueue();
        pq.offer(new Bus(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Bus bus = pq.poll();
            int busEnd = bus.end;

            if (!visited[busEnd]) {
                visited[busEnd] = true;
                for (Bus b :
                        list.get(busEnd)) {
                    if (!visited[b.end] && dist[b.end] > dist[busEnd] + b.value) {
                        dist[b.end] = dist[busEnd] + b.value;
                        pq.offer(new Bus(b.end, dist[b.end]));
                    }
                }
            }
        }
        ans = dist[end];
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        ans = 0;

        list = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.get(start).add(new Bus(end, value));
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

    }
}
