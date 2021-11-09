// BOJ_14501_퇴사
// https://www.acmicpc.net/problem/14501

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501 {

	static int N, max, arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken()); // 상담기간
			arr[i][1] = Integer.parseInt(st.nextToken()); // 금액
		}

		recur(1, 0);
		System.out.println(max);

	}// main close

	private static void recur(int today, int price) {
		
		max = Math.max(max, price);
		
		if (today == N + 1) { // 기저조건
			return;
		}

		// 상담을 할 때 상담이 근무일 이내에 끝나야 한다.
		if (today + arr[today][0] <= N + 1) {
			recur(today + arr[today][0], price + arr[today][1]);
		}

		// 상담을 하지 않을 때
		recur(today + 1, price);

	}// recur close

}
