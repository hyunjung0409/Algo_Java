// https://www.acmicpc.net/problem/2491
// BOJ_2491_수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2491 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		String str = br.readLine();
		for (int i = 0, idx=0; i < N; i++, idx+=2) {
			num[i] = str.charAt(idx) - '0';
		}
		//System.out.println(Arrays.toString(num));
				
		int cnt = 1, result=1;
		
		//증가하는 수열
		for (int i = 0; i < N-1; i++) {
			if(num[i] <= num[i+1]) {
				cnt++;
			}
			else {
				cnt = 1;
			}
			result = Math.max(result, cnt);
		}
		
		cnt=1; //cnt 초기화
		//감소하는 수열
		for (int i = 0; i < N-1; i++) {
			if(num[i] >= num[i+1]) {
				cnt++;
			}
			else {
				cnt = 1;

			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}
}
