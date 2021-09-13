import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {

	static int N, M, num[], dp[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N + 1];
		dp = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			dp[i] = dp[i - 1] + num[i];
		}

		for (int tc = 0; tc < M; tc++) {
			int result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			result = dp[j] - dp[i-1];
			sb.append(result + "\n");
		}

		System.out.print(sb.toString());
	}

}