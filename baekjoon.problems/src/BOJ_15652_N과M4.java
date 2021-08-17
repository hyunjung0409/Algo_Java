import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합 + 이미 선택한 숫자를 다시 선택할 수 있음 --> 중복조합
public class BOJ_15652_N과M4 {
	static int N, M;
	static int combination[];
	static StringBuilder sb =new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		combination = new int[M];
		
		makeCombination(0,1);
		System.out.println(sb);
	}

	private static void makeCombination(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(combination[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {			
			combination[cnt] = i;
			makeCombination(cnt+1, i); //i --> 현재 선택한 수부터 선택하도록
		}
	}
}