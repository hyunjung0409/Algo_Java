// BOJ_1003_피보나치 함수
// https://www.acmicpc.net/problem/1003

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] cnt = new int[40+1][2];
			cnt[0][0] = 1;
			cnt[0][1] = 0;
			cnt[1][0] = 0;
			cnt[1][1] = 1;

			for (int i = 2; i <= N; i++) {
				cnt[i][0] = cnt[i-1][0] + cnt[i-2][0];
				cnt[i][1] = cnt[i-1][1] + cnt[i-2][1];
			}
			sb.append(cnt[N][0] + " " + cnt[N][1]);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}