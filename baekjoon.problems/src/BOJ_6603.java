//BOJ_6603_로또
//https://www.acmicpc.net/problem/6603

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603 {

	static int N, M, num[], comb[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;
			else {
				M = 6;
				num = new int[N];
				comb = new int[M];
				for (int i = 0; i < N; i++) {
					num[i] = Integer.parseInt(st.nextToken());
				}
				//System.out.println(Arrays.toString(num));
				makeComb(0, 0);
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());

	}// main close

	private static void makeComb(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(comb[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <N; i++) {
			comb[cnt] = num[i];
			makeComb(cnt+1, i+1);
		}
	}//makeComb close

}// class close
