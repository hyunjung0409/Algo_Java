//4등분을 계속해서 구역별로 확인 --> 분할정복
//BOJ_1992_쿼드트리
//https://www.acmicpc.net/problem/1992

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1992 {
	static int N, map[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) -'0';
			}
		}
		
		divide(0,0,N);
		System.out.println(sb.toString());
		
	}

	private static void divide(int r, int c, int size) {
		if(check(r, c, size)) { //파티션의 점이 모두 동일하다면
			if(map[r][c] == 0)
				sb.append(0);
			else
				sb.append(1);
			return;
		}
		
		int newSize = size/2; //절반 사이즈
		
		sb.append('(');
		
		//재귀함수 호출
		divide(r, c, newSize);
		divide(r, c+newSize, newSize);
		divide(r+newSize, c, newSize);
		divide(r+newSize, c+newSize, newSize);
			
		sb.append(')');
		
	} //divide close
	
	//현재 섹션의 각 점들이 같은지 체크
	private static boolean check(int r, int c, int size) {
		
		int first = map[r][c]; //첫번째 원소를 기준으로 체크
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(map[i][j] != first) //점이 같지 않다면 false 리턴
					return false;
			}
		}
		
		//검살ㄹ 모두 통과 --> 같다는 의미이므로 true 리턴 
		return true; 
	} //check close

}
