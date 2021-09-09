//BOJ_1010_다리 놓기
//https://www.acmicpc.net/problem/1010

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
	// 한 사이트에 한 개의 다리만, 서로 다른 다리가 겹치면 안됨
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			System.out.printf("%.0f\n", makeComb(M, N));
		}
	
	}//main close

	private static double makeComb(int n, int r) {
		double a=1, b=1;
		
		for (double i=n; i>=n-(r-1); i--) {
			a *= i;
		}
		for (double i = r; i >0; i--) {
			b *= i;
		}
		return a/b;
	}
}