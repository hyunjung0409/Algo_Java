import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//중복순열
public class BOJ_15656_N과M7 {
	static int N, M, numbers[], permutaiton[];
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
		
		permutaiton = new int[M];
		
		makePermutaiton(0);
		System.out.println(sb.toString());
		
	}//main close

	private static void makePermutaiton(int cnt) {
		if(cnt==M) {
			for (int i = 0; i < M; i++) {
				sb.append(permutaiton[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int idx = 0; idx < N; idx++) {
			permutaiton[cnt] = numbers[idx];
			makePermutaiton(cnt+1);
		}
		
	}

}