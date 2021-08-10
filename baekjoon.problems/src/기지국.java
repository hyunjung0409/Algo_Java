import java.util.Arrays;
import java.util.Scanner;

public class 기지국 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int tc = sc.nextInt();//테스트 케이스 수
		int size = 0; //배열 크기
		
		//배열에 입력
		for(int t=0; t<tc; t++) {
			size = sc.nextInt(); // 0<= size <=50 (변수의 타입을 생각해야 한다.)
			char[][] map = new char[size][size];
			
			for(int i=0; i<map.length; i++) {
				String str = sc.next(); 
				for(int j=0; j<map.length; j++) {
					map[i][j] = str.charAt(j); //배열에 입력
				}
			}
			
			//배열 순회 기지국 찾기
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map.length; j++) {
					if(map[i][j] != 'X' && map[i][j] != 'H') { //기지국
						//H가 있으면 X로 변경. A 1, B 2, C 3 (동서남북)
						//map[i][j] - 'A' +1 = ?
						for (int k = 1; k <= map[i][j]-'A'+1; k++) { //떨어진 칸. A 1, B 2, C 3
							//상하좌우 H가 있으면 X로 변경 (k 범위)
							if(j+k < size && map[i][j+k] == 'H') {//우
								map[i][j+k] = 'X';
							}
							if(0<= j+k && map[i][j-k] == 'H') {//좌
								map[i][j-k] = 'X';
							}
							if(j+k < size && map[i-k][j] == 'H') {//상
								map[i-k][j] = 'X';
							}
							if(0<= j+k && map[i+k][j] == 'H') {//하
								map[i+k][j] = 'X';
							}
						}
						
					}
				}
			}
			
			//배열 순회 H 개수 카운팅
			int cnt=0;
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map.length; j++) {
					if(map[i][j]== 'H') { //커버되지 않는 집
						cnt++;						
					}
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		}// end of test case
	}//end of main
}