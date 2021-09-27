// BOJ_2599_수열
// https://www.acmicpc.net/problem/2559

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2599 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //온도를 측정한 전체 날짜 수
		int K = Integer.parseInt(st.nextToken()); //합을 구하기 위한 연속적인 날짜의 수
		
		int[] temp = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		//온도가 -100 ~ 100까지로 0으로 초기화하면 안됨.
		//초기화는 Integer.MIN_VALUE; 로 하기 !!!
		long max = Integer.MIN_VALUE;
		long sum = Integer.MIN_VALUE;

		for (int i = 0; i <= N-K; i++) {
			sum = temp[i];
			for (int j = i+1; j < i+K; j++) {
				sum += temp[j];
			}
			max = Math.max(sum, max);
			sum = 0;
		}
		System.out.println(max);
	}

}
