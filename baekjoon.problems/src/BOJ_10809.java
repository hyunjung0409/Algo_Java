// BOJ_10809_알파벳 찾기
// https://www.acmicpc.net/problem/10809

import java.util.Scanner;

public class BOJ_10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//알파벳 개수만큼의 일차원 배열 생성
		int[] arr = new int[26];
		for (int i = 0; i < 26; i++) {
			arr[i] = -1;
		}
		
		// a --> 97
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 97;
			if(arr[idx] == -1)
				arr[idx] = i;
			else
				continue;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb.toString());
	}
}