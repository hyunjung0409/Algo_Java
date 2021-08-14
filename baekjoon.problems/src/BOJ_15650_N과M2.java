import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650_N과M2 {
	static int N, M; //1부터 N까지의 정수 중 M개 원소를 갖는 조합 생성
	static int comb[]; //M개 크기의 배열, 조합이 저장될 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		comb = new int[M]; //조합이 저장될 배열!! 무조건 조합 메소드 전에 초기화해야 함!!!
		
		makeCombination(0, 1);

	}//comb close
	
	/*	@param cnt	현재까지 뽑은 조합 원소 개수
		@param start 조합 시도할 원소의 시작 숫자	*/
	private static void makeCombination(int cnt, int start) {
		StringBuilder sb = new StringBuilder();
		if(cnt == M) { //조합 생성 완료
			for (int i = 0; i < M; i++) {
				sb.append(comb[i]+" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		//start 위치의 수부터 가능한 모든 수 고려
		for (int i = start; i <= N; i++) { //start 숫자부터 N까지
			comb[cnt] = i; 
			makeCombination(cnt+1, i+1);
		}
	}
}//class close