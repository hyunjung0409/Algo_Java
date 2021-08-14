import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//순열 + 이미 선택한 숫자를 다시 선택할 수 있음 --> 중복순열
public class BOJ_15651_N과M3 {
	static int N, M;
	static int permutation[];
	static StringBuilder sb =new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		permutation = new int[M];
		
		makePermutation(0);
		System.out.println(sb);
	}

	private static void makePermutation(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(permutation[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {			
			permutation[cnt] = i;
			makePermutation(cnt+1);
		}
	}
}