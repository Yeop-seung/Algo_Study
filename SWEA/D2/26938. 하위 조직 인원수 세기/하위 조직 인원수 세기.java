/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int[] leftChild, rightChild;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int E = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            // Initialize child arrays for nodes 1..E+1
            int size = E + 2; // node indices up to E+1
            leftChild = new int[size];
            rightChild = new int[size];

            // Read 2*E integers (E pairs). They may span lines, so keep reading until collected.
            List<Integer> tokens = new ArrayList<>();
            while (tokens.size() < 2 * E) {
                String line = br.readLine();
                if (line == null || line.isEmpty()) continue;
                StringTokenizer st2 = new StringTokenizer(line);
                while (st2.hasMoreTokens()) tokens.add(Integer.parseInt(st2.nextToken()));
            }

            for (int i = 0; i < E; i++) {
                int parent = tokens.get(2 * i);
                int child = tokens.get(2 * i + 1);
                if (child == 0) continue;
                if (leftChild[parent] == 0) leftChild[parent] = child;
                else rightChild[parent] = child;
            }

            int ans = countSubtree(N);
            sb.append("#").append(testcase).append(" ").append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }

    static int countSubtree(int node) {
        if (node == 0) return 0;
        int cnt = 1;
        cnt += countSubtree(leftChild[node]);
        cnt += countSubtree(rightChild[node]);
        return cnt;
    }
}