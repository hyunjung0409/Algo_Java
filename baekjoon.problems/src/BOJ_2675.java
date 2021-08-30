// BOJ_2675_문자열 반복
// https://www.acmicpc.net/problem/2675

import java.util.Scanner;

public class BOJ_2675 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			
			int R = sc.nextInt();
			String str = sc.next();
			
			for (int j = 0; j < str.length(); j++) {
				char input = str.charAt(j);
				for (int k = 0; k <R; k++) {
					sb.append(input);
				}
			}
			
			sb.append("\n");
		}//T close
		
		System.out.print(sb.toString());
		
	}//main close

}
