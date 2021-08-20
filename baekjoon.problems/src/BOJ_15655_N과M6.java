import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//입력받은 N개의 자연수 중에서 M개를 고른 조합을 오름차순으로 출력
public class BOJ_15655_N과M6 {
	static int N, M, numbers[], combination[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		
		combination = new int[M];
		makeCombination(0,0);
		System.out.println(sb.toString());
	}//main close

	private static void makeCombination(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(combination[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int idx = start; idx < N; idx++) {
			combination[cnt] = numbers[idx];
			makeCombination(cnt+1, idx+1);
		}
	}//makeCombination close
}