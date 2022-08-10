import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int min;
	static boolean[] isSeleted;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		int[][] checkArr = new int[K][3];
		isSeleted = new boolean[K];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			checkArr[i][0] = Integer.parseInt(st.nextToken());
			checkArr[i][1] = Integer.parseInt(st.nextToken());
			checkArr[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] temp = new int[N][M];
		temp = init(temp);
		checkLoop(K, checkArr, temp, new ArrayList<Integer>());

		sb.append(min);
		br.close();
		System.out.println(sb);
	}

	private static void checkLoop(int K, int[][] checkArr, int[][] temp, ArrayList<Integer> perm) {
		if (perm.size() == K) {
			init(temp);
			for (Integer idx : perm) {
				int r = checkArr[idx][0];
				int c = checkArr[idx][1];
				int s = checkArr[idx][2];

				temp = loop(r, c, s, temp);
			}
			for (int j = 0; j < temp.length; j++) {
				int sum = 0;
				for (int j2 = 0; j2 < temp[j].length; j2++) {
					sum += temp[j][j2];
				}
				min = Math.min(min, sum);
			}
			return;
		}
		for (int i = 0; i < checkArr.length; i++) {
			if (isSeleted[i])
				continue;
			isSeleted[i] = true;
			perm.add(i);

			checkLoop(K, checkArr, temp, perm);
			isSeleted[i] = false;
			perm.remove(perm.size() - 1);
		}
	}

	private static int[][] init(int[][] temp) {
		for (int j = 0; j < arr.length; j++) {
			for (int j2 = 0; j2 < arr[j].length; j2++) {
				temp[j][j2] = arr[j][j2];
			}
		}
		return temp;
	}

	private static int[][] loop(int r, int c, int s, int[][] arr) {
		int yStart = r - s - 1;
		int yEnd = r + s - 1;
		int xStart = c - s - 1;
		int xEnd = c + s - 1;
		int temp1 = 0;
		int temp2 = 0;
		int temp3 = 0;
		int num = Math.min((yEnd - yStart), (xEnd - xStart));
		for (int j = 0; j < num / 2; j++) {
			temp3 = arr[yStart][xStart];
			temp1 = arr[yStart][xEnd];
			for (int v = xEnd; v > xStart; v--) {
				arr[yStart][v] = arr[yStart][v - 1];
			}
			++yStart;
			temp2 = arr[yEnd][xEnd];
			for (int v = yEnd; v >= yStart; v--) {
				arr[v][xEnd] = arr[v - 1][xEnd];
			}
			arr[yStart][xEnd] = temp1;
			temp1 = temp2;
			--xEnd;
			temp2 = arr[yEnd][xStart];
			for (int v = xStart; v < xEnd; v++) {
				arr[yEnd][v] = arr[yEnd][v + 1];
			}
			arr[yEnd][xEnd] = temp1;
			temp1 = temp2;
			--yEnd;
			temp2 = arr[yEnd][xStart];
			for (int v = yStart - 1; v < yEnd; v++) {
				arr[v][xStart] = arr[v + 1][xStart];
			}
			arr[yEnd][xStart] = temp1;
			++xStart;
		}
		return arr;
	}

}
