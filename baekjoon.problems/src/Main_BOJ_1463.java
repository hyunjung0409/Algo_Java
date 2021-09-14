
//BOJ_1463_1로 만들기
//https://www.acmicpc.net/problem/1463

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1000000 + 1]; // 최대값에 1을 더해준다.

		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1); //1을 빼준 연산과 2로 나눠준 연산 중 최소값
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1); //1을 빼준 연산과 3으로 나눠준 연산 중 최소값
			}
		}
		System.out.println(dp[N]);
	}

}
