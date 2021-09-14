import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] price = new int[N][3];
		int[][] dp = new int[N][3];
		
		//price 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			price[i][0] = Integer.parseInt(st.nextToken());
			price[i][1] = Integer.parseInt(st.nextToken());
			price[i][2] = Integer.parseInt(st.nextToken());
		}
		
		//집이 한 채일 경우
		for (int i = 0; i < 3; i++) {
			dp[0][i] = price[0][i];
		}
		
		//집이 한 채 이상일 경우, 이전 집에 칠해진 색깔 이외의 색 중의 최소값을 가져와 더함
		for (int i = 1; i < N; i++) {
			dp[i][0] = price[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = price[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = price[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		//최소값 찾기
		int min = Math.min(dp[N-1][0], dp[N-1][1]);
		min = Math.min(min, dp[N-1][2]);
		
		System.out.println(min);
	}

}
