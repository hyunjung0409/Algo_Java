
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

//테스트 횟수 T 입력 -> T만큼 반복
//농장 크기 N 입력 -> int[N][N] 만들기
//행마다 String 입력 -> 문자를 정수로 변환하여 배열에 저장
//N/2를 기준으로 1씩 점차 증감 -> 갭 0으로 설정 -> N/2까지 증가하고 이후 감소. 

public class SWEA_2805_농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt(); //테스트 횟수

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); //농장 크기 N
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.next(); //행마다 string 입력
				for (int j = 0; j < N; j++) {
					//아스키 코드 --> 숫자1: 49, 숫자0: 48
					map[i][j] = str.charAt(j)-'0';
				}
			}//배열 입력 끝
			// System.out.println(Arrays.deepToString(map));
			
			int sum =0, gap=0, mid=N/2;
			for(int i=0; i<N; i++) {
				int st = mid-gap; 
				int end = mid+gap;
				for(int j=st; j<=end; j++) { //시작시점부터 끝지점..
					sum += map[i][j];
				}
				if(i<mid) 
					gap++; // N/2 전까지 1씩 증가
				else
					gap--; // N/2부터 1씩 감소
			}
			System.out.println("#"+test_case+" "+sum);
			
		}//테스트 케이스 반복
		
	}

}