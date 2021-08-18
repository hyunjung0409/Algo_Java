//분할정복
//BOJ_2630_색종이 만들기
//https://www.acmicpc.net/problem/2630

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
	static int N, map[][];
	static int white=0, blue=0;
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//map에 입력
		
		partition(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}


	private static void partition(int r, int c, int size) {
		
		if(check(r, c, size)) { //파티션의 색깔이 모두 동일하다면
			if(map[r][c] == 0) 
				white++;
			else
				blue++;
			return;
		}
		
		int newSize = size/2; //절반 사이즈
		
		//재귀 호출
		partition(r, c, newSize);
		partition(r, c+newSize, newSize);
		partition(r+newSize, c, newSize);
		partition(r+newSize, c+newSize, newSize);
	}

	//현재 파티션의 컬러가 같은지 체크
	private static boolean check(int r, int c, int size) {
		
		int color = map[r][c]; //첫번째 원소를 기준으로 체크
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(map[i][j] != color) { //색상이 같지 않다면 false 리턴
					return false;
				}
			}
		}
		
		//검사를 모두 통과 --> 같다는 의미이므로 true 리턴
		return true;
	}

}