import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16439_2 {
	
	static int N, M, comb[], chicken[][];
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //N명의 사람
		M = Integer.parseInt(st.nextToken()); //M가지 치킨 종류
		chicken = new int[N][M];
		
		for (int i = 0; i < N; i++) { //선호도 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <M; j++) {
				chicken[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb = new int[3]; //세 가지 종류의 치킨
		makeComb(0, 0);
		
		System.out.println(result);
	}//end of main
	
	private static void makeComb(int cnt, int start) {
		
		//M 개의 치킨 종류 중 세 종류만 뽑아 그것의 합을 구함
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += getMax(i);
			}
			if(sum>result)
				result = sum;
			return;
		}
		
		//치킨 종류 조합 생성
		for (int i = start; i < M; i++) {
			comb[cnt] = i;
			makeComb(cnt+1, i+1);
		}
	}//end of makeComb
	
	//치킨 세 종류 중 개인 선호도가 가장 높은 것을 리턴
	private static int getMax(int idx) {
		int max = 0;
		for (int i = 0; i < 3; i++) {
			int temp = chicken[idx][comb[i]];
			if(temp>max)
				max=temp;
		}
		return max;
	}//end of getMax

}