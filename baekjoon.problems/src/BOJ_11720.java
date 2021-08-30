// BOJ_11720_숫자의 합
// https://www.acmicpc.net/problem/11720

import java.util.Scanner;

public class BOJ_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int sum=0;
		String str = sc.next();
		for (int i = 0; i < N; i++) {
			sum += (str.charAt(i)-48);
		}
		System.out.print(sum);
	}
}