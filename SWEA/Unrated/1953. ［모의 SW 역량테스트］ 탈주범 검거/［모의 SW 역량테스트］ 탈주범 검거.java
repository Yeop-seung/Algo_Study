import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

static int T, N, M, R, C, L, ans;
static int[][] map;
static boolean[][] visit;

static Queue<Node> queue = new ArrayDeque<>();

// delta
//    static int[] dy = { -1, 1, 0, 0};
//    static int[] dx = {  0, 0,-1, 1};

    // 0 index => 구조물 종류 0 dummy
    // dy[3][0] => 3번 구조물에서 첫번째 이동방얗
    static int[][] dy = {
            //  상하좌우                       상하                        좌우                       상우                           하우                          하좌                          상좌
            {}, { -1, 1, 0, 0 }, {-1, 1, 0, 0}, {0, 0, 0, 0}, {-1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 0, 0 }, { -1, 0, 0, 0 }
    };
    static int[][] dx = {
            {}, {  0, 0,-1, 1 }, { 0, 0, 0, 0}, {0, 0,-1, 1}, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0,-1, 0 }, { 0, 0, -1, 0 }
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 풀이
            ans = 1; // 맨 처음 시작 ( 1시간 지난...) 도 포함
            queue.clear();

            visit[R][C] = true;
            queue.offer(new Node(R, C, 1));
            bfs(); // ans 누적 증가

            System.out.println("#" + t + " " + ans);
        }
    }

// 움직이는 방향에 따라서 to 에서 받아줄 수 있는지 boolean 리턴
static boolean connect(int dir, int to) {
    if( to == 1 ) return true; // 1번은 모두 받아 준다.
    switch( dir ) {
        case 0: if( to == 2 || to == 5 || to == 6 ) return true; break; // 상
        case 1: if( to == 2 || to == 4 || to == 7 ) return true; break; // 하
        case 2: if( to == 3 || to == 4 || to == 5 ) return true; break; // 좌
        case 3: if( to == 3 || to == 6 || to == 7 ) return true; break; // 우
    }
    return false;
}

static void bfs() {
    
    while( ! queue.isEmpty() ) {
        Node node = queue.poll();
        // 기저조건
        if( node.t == L ) return;
        
        // 현재 꺼낸 node (좌표, 지점) 어떤 파이프인지 구별 => 해당하는 delta 얻을 수 있다.
        int current = map[node.y][node.x]; // 현재 어떤 구조물(파이프)
        int[] deltaY = dy[current]; // { 1, -1, 0, 0 } 
        int[] deltaX = dx[current]; // { 0,  0, 1,-1 }
        
        for (int d = 0; d < 4; d++) {
            // delta y, x 가 모두 0 이면 이동이 없으므로  skip
            if( deltaY[d] == 0 && deltaX[d] == 0 ) continue; 
            int ny = node.y + deltaY[d];
            int nx = node.x + deltaX[d];
            // 이동하려는 ny, nx 에 대해서 기본적인 valid 체크
            if( ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] ) continue;
            
            // 현재 좌표에서는 통과해서 이제 이동시도
            int next = map[ny][nx];
            // next가 받아 줄 수 있는지 
            if( next == 0 || ! connect( d, next )) continue;
            
            // 비로소 이동
            visit[ny][nx] = true;
            queue.offer(new Node( ny, nx, node.t + 1));
            // 갈 수 있는 곳 추가
            ans++;
        }
    }
}

static class Node{
    int y, x, t; // t: 경과되는 시간
    Node( int y, int x, int t){
        this.y = y;
        this.x = x;
        this.t = t;
    }
}
}