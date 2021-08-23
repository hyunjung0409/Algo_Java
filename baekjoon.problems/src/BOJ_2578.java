// https://www.acmicpc.net/problem/2578
// BOJ_2578_빙고

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {
	
	static int[][] map = new int[5][5]; //빙고 배열
	static int[] garo = new int[5]; //가로 카운트
	static int[] sero = new int[5]; //세로 카운트
	static int[] daegag = new int[2]; //대각선 카운트
	static int cnt=0; //빙고 카운트
	static int say=0; //사회자 카운트
	static boolean bingo = false; //빙고 완성 유무
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//빙고 입력
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				say++; //사회자가 부른 횟수 더해줌
				bingoCheck(Integer.parseInt(st.nextToken())); //사회자가 부르는 숫자로 빙고 체크
				if(bingo) { //빙고 3개 완성되면
					System.out.println(say); //출력
					return; //나가기 (return 없으면 이후에도 계속 출력됨)
				}
			}
		}
		
	}//main close

	private static void bingoCheck(int num) {
		for (int r = 0; r <5; r++) {
			for (int c = 0; c < 5; c++) {
				if(map[r][c] == num) {
					//가로, 세로 체크
					garo[r] ++;
					sero[c] ++;
					if(garo[r] == 5) cnt++;
					if(sero[r] == 5) cnt++;
					
					//대각선 체크 (우상)
					if(r == c) {
						daegag[0]++;
						if(daegag[0] == 5) cnt++;
					}
				}
				//대각선 체크 (우하)
				if(map[4-c][c] == num) {
					daegag[1]++;
					if(daegag[1] == 5) cnt++;
				}
				
				if(cnt > 2) {
					bingo = true;
					return;
				}
			}
		}
	}//bingoCheck close

}//class close