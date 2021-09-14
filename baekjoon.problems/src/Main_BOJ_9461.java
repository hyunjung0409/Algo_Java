//https://www.acmicpc.net/problem/9461
//파도반 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_9461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] p = new long[100+1]; //입력 최대값 +1
			
			p[1] = 1;
			p[2] = 1;
			p[3] = 1;
			p[4] = 2;
			p[5] = 2;
			
			for (int i = 6; i <=N; i++) {
				p[i] = p[i-5] + p[i-1];
			}
			sb.append(p[N]+"\n");
		}
		System.out.print(sb.toString());
	}
}