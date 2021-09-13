import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16439 {

	static int N, M, chicken[][], comb[];
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chicken = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				chicken[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// System.out.println(Arrays.deepToString(chicken));

		comb = new int[3];
		makeComb(0, 0);
		System.out.println();
		System.out.println(max);

	}

	private static void makeComb(int cnt, int start) {

		if (cnt == 3) { //치킨 세 종류를 모두 뽑았을 때,

//			for (int i = 0; i < 3; i++) {
//				System.out.print(comb[i] + " ");
//			}
//			System.out.println();

			int sum = 0;
			
			//치킨 세 종류 중 개인 선호도가 가장 높은 것을 골라 sum에 더한다
			for (int i = 0; i < N; i++) {
				sum += getMax(i);
			}
			if (sum > max)
				max = sum;
			return;
		}

		//M 개의 치킨 종류 중 세 종류만 뽑는다(cnt=3일 때, return)
		for (int i = start; i < M; i++) {
			comb[cnt] = i;
			makeComb(cnt + 1, i + 1);
		}
	}

	private static int getMax(int idx) {//치킨 세 종류 중 개인 선호도가 가장 높은 것을 리턴
		int max = 0;
		for (int j = 0; j < 3; j++) {
			if (chicken[idx][comb[j]] > max) {
				max = chicken[idx][comb[j]];
				//System.out.println(chicken[idx][comb[j]]);
			}
		}
		return max;
	}

}
