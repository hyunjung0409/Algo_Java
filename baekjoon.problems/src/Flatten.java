
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//10번 반복
//덤프횟수 입력(1이상 1000이하)
//상자 높이 입력 (가로 길이 100) (높이 1이상 100이하)
//주어진 덤프횟수 이내에 평탄화 완료되면 그때 최고점, 최저점 높이 차 반환)
//출력 #테스트케이스 번호 높이 차
public class Flatten {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input_flatten.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1; tc<=10; tc++) { //tc 10번 반복
			int dump = Integer.parseInt(br.readLine()); //덤프횟수 입력
			int[] box = new int[100];						
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<100; i++) { //배열에 상자 높이 입력
				box[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(box); //상자 높이 배열 정렬
			
			//평준화
			while(dump-- >0) { //주어진 dump 횟수만큼 반복
				box[0]++; 
				box[99]--;
				Arrays.sort(box); //배열 다시 정렬				
			}//덤프 반복 끝
		
			System.out.println("#"+tc+" "+(box[99]-box[0]));	
		} // 10번 반복 끝
		
	}//메인 끝
}
