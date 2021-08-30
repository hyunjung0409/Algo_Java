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
		char ch='?';
		for (int i = 0; i < 26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				ch = (char)(i+65);
			}
			else if(arr[i] == max) {
				ch='?';
			}
		}
		System.out.print(ch);
	}
}