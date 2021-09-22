// BOJ_1182_부분수열의 합
// https://www.acmicpc.net/problem/1182

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1182 {
	
	static int N, S,sumCount=0;
	static int[] input;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		input = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i <N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		makePowerSet(0);
		System.out.println(S==0?sumCount-1:sumCount);
	}
	
	private static void makePowerSet(int cnt) {
		
		if(cnt == N) {
			int sum=0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sum += input[i];
				}
			}
			if(sum == S) {
				sumCount++;
			}
			return;
		}
		
		isSelected[cnt] = true; //현재 원소를 선택
		makePowerSet(cnt+1);
		isSelected[cnt] = false; //비선택
		makePowerSet(cnt+1);		
	}

}
