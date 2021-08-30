// BOJ_1157_단어 공부
// https://www.acmicpc.net/problem/1157

import java.util.Scanner;

public class BOJ_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[26];

		String str = sc.next();
		// A -> 65 a -> 97
		//사용된 알파벳 카운트
		for (int i = 0; i < str.length(); i++) {
			int input = str.charAt(i);
			if (input - 97 >= 0) {
				arr[input - 97]++;
			} else {
				arr[input - 65]++;
			}
		}
		
		//가장 많이 사용된 알파벳 찾기
		int max = -1;
		for (int i = 0; i < 26; i++) {
			max = Math.max(arr[i], max);
		}
		
		//출력
		int cnt=0, idx=0;
		for (int i = 0; i < 26; i++) {
			if(arr[i] == max) {
				cnt++;
				idx = i;
			}
		}
		if(cnt > 1)
			System.out.println("?");
		else if(cnt == 1) {
			System.out.println((char)(idx+65));
		}
	}

}
