// https://www.acmicpc.net/problem/10163
// BOJ_10163_색종이

import java.util.Scanner;

public class BOJ_10163 {
	static int[][] map;
	static int N; //색종이 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new int[1001][1001];
		N = sc.nextInt();
		int[] result = new int[N+1];		
		
		for (int n = 1; n <= N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			//색종이 그리기
			for (int i = x; i < x+w; i++) {
				for (int j = y; j < y+h; j++) {
					map[i][j] = n;
				}
			}
		}
		
		//print();
		
		//색종이 보이는 부분 카운트
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] != 0) {
					result[map[i][j]]++;
				}
			}
		}
		
		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	}//main close

	/*private static void print() {
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
		
	}*/
}
