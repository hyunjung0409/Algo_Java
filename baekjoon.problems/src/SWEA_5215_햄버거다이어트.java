import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거다이어트 {
	static int N, L, maxScore;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 T
		
		for (int tc = 1; tc <= T; tc++) {
			String str= br.readLine();
			st = new StringTokenizer(str, " ");
			N = Integer.parseInt(st.nextToken()); //재료의 수 N
			L = Integer.parseInt(st.nextToken()); //제한 칼로리 L
			
			arr = new int[N][2];
			
			for (int n = 0; n < N; n++) {
				String str2= br.readLine();
				st = new StringTokenizer(str2, " ");
				arr[n][0] = Integer.parseInt(st.nextToken()); //재료에 대한 맛 점수
				arr[n][1] = Integer.parseInt(st.nextToken()); //칼로리
			}//N 반복 close
			
			maxScore = 0;
			select(0, 0, 0);
			
			System.out.println("#"+tc+ " "+ maxScore);
			
		}//T 반복 close
	}

	private static void select(int idx, int score, int cal) {
		if(cal > L) //제한 칼로리 초과
			return;
		if(cal <= L)
			maxScore = Math.max(maxScore, score);
		if(idx == N) //N까지 모두 탐색
			return;
		
		select(idx+1, score+arr[idx][0], cal+arr[idx][1]);
		
		select(idx+1, score, cal);
	}

}