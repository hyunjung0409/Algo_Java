// BOJ_12865_평범한 배낭
// https://www.acmicpc.net/problem/12865

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_12865 {

	static int N, K; // 물품 개수, 가방 무게
	static int value[], weight[], dp[]; // 물품 가치, 무게, 무게 별 최적해

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		weight = new int[N + 1];
		value = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[K + 1];
		for (int i = 1; i <= N; i++) {
			for (int w = K; w >= weight[i]; w--) {
				dp[w] = Math.max(dp[w], value[i] + dp[w - weight[i]]);
			}
		}
		System.out.println(dp[K]);
	}
	
}