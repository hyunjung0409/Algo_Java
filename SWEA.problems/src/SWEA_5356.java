// SWEA_5356
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVWgkP6sQ0DFAUO#

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_5356 {
	
	static int T;
	static char[][] s;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("의석이.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <=T; tc++) {
			//각 줄에 1이상 15이하인 문자열이 주어진다고 하였으므로 15로 설정
			/*s = new char[5][15];
			//공백으로 초기화
			for (int i = 0; i < 5; i++) {
				Arrays.fill(s[i], ' ');
			}
			
			for (int r = 0; r <5; r++) {
				String str = sc.next();
				int len = str.length();
				for (int c = 0; c < len; c++) {
					s[r][c] = str.charAt(c);
				}
			}
			//System.out.println(Arrays.deepToString(s));
			
			sb.append("#"+tc+" ");
			for (int c = 0; c < 15; c++) {
				for (int r = 0; r < 5; r++) {
					if(s[r][c]!=' ') {
						sb.append(s[r][c]);
					}
				}
			}
			sb.append("\n");
			*/

			String[] ss = new String[5];
			for (int i = 0; i < 5; i++) {
				ss[i]=sc.next();
			}
			int max=0;
			for (int i = 0; i < 5; i++) {
				max = Math.max(max, ss[i].length());
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < 5; j++) {
					if(ss[j].length()<=i) {
						continue;
					}
					System.out.print(ss[j].charAt(i));
				}
			}
			System.out.println();
		}//T close
		//System.out.print(sb.toString());
	}
}