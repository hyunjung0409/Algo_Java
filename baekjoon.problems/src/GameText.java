
import java.util.Scanner;

//가위바위보 게임 하는 클래스
public class GameText {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		// 게임 메뉴 출력
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승"); 
		System.out.println("2. 3판 2승");  
		System.out.println("3. 1판 1승");  
		System.out.print("번호를 입력하세요.");
		
		int menu = sc.nextInt();
		int comWin=0, userWin = 0;
		int totalCnt=0, winCnt=0, gameCnt = 0;
		int comNo=0, userNo = 0;
		
		switch(menu) {
		case 1: totalCnt =5; winCnt=3; break;
		case 2: totalCnt = 3; winCnt=2; break;
		case 3: totalCnt = 1; winCnt=1; break;
		}
		
		while(gameCnt++<totalCnt && (comWin<winCnt && userWin<winCnt)) {
			System.out.println("가위바위보 중 하나 입력: ");
			comNo = (int)(Math.random()*3)+1;	// 난수로 컴퓨터 가위,바위,보 선택
			userNo = sc.nextInt();				// 입력으로 사용자 가위,바위,보 선택
			
			if(comNo==1) {						// 컴퓨터가 가위를 선택했을 경우
				if(userNo==1) {
					System.out.println("비겼습니다.");
				}else if(userNo==2) {
					System.out.println("이겼습니다.");
					userWin++;
				}else {
					System.out.println("졌습니다.");
					comWin++;
				}
			}else if(comNo==2) {				// 컴퓨터가 바위를 선택했을 경우
				if(userNo==1) {
					System.out.println("졌습니다.");
					comWin++;
				}else if(userNo==2) {
					System.out.println("비겼습니다.");
				}else {
					System.out.println("이겼습니다.");
					userWin++;
				}
			}else {								// 컴퓨터가 보를 선택했을 경우
				if(userNo==1) {
					System.out.println("이겼습니다.");
					userWin++;
				}else if(userNo==2) {
					System.out.println("졌습니다.");
					comWin++;
				}else {
					System.out.println("비겼습니다.");
				}
			}
			
		}
		// 사용자 승리횟수와 컴퓨터 승리횟수 비교하여 최종 결과 출력
		if(userWin>comWin) {
			System.out.println("### 사용자 승!!!");
		}else if(userWin<comWin) {
			System.out.println("### 컴퓨터 승!!!");
		}else {
			System.out.println("### 무승부!!!");
		}
		sc.close();
	}
}
		