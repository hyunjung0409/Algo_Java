import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1940_가랏RC카 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine()); //Command 개수 (2<=N<30)
			int v=0; //현재 속도
			int m=0; //총 이동거리. 더하기 연산자의 항등원
			
			for (int n = 0; n < N; n++) { //명령문만큼 반복
				String com = br.readLine();
				switch(com.charAt(0)) { //명령어
				case '0': //현재 속도 유지
					break;
					
				case '1': //가속
					v += com.charAt(2) - '0';
					break;
					
				case'2': //감속
					v -= com.charAt(2) - '0';
					//v = v - (com.charAt(2) - '0'); //괄호 먼저 계산
					if(v<0) v=0;
					break;
				}
				m += v; //현재 속도*1만큼 이동한 거리 누적
				
			}
			System.out.println("#"+tc+" "+m);
			
		}//T end
		
	}//main end
}