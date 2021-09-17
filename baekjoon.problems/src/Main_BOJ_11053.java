
// BOJ_11053_가장 긴 증가하는 부분 수열
// https://www.acmicpc.net/problem/1105

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n이 1000 이하로 DP로 풀이 (n제곱)
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		int[] LIS = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			LIS[i] = 1; //자기 자신을 놓는 최소값(1)로 초기화
			for (int j = 0; j < i; j++) { //j: i의 앞쪽 원소
				//자기 자신(i)가 더 크고, 앞쪽 원소 길이+1 보다 짧을 때
				if(num[i]>num[j] && LIS[i]<LIS[j]+1)
					LIS[i] = LIS[j]+1;
			}//i를 끝으로 하는 최장 길이 계산 완료
			//LIS[i]: i를 끝으로 하는 최장 증가 수열의 길이
			if(max<LIS[i]) max = LIS[i];
		}
		System.out.println(max);
	}
}