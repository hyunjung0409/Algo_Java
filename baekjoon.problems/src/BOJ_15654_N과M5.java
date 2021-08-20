import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//입력 받은 N개의 자연수 중에서 M개를 고른 순열
public class BOJ_15654_N과M5 {
	
	static int N, M, numbers[], permutation[];
	static boolean isSelected[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[N];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		} //numbers 배열에 입력받은 N개의 정수 입력
		Arrays.sort(numbers); //입력 받은 정수를 정렬
		
		permutation = new int[M];
		makePermutation(0);	
		
		Arrays.sort(permutation);
		System.out.println(sb.toString());
	}

	private static void makePermutation(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(permutation[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int idx = 0; idx < N; idx++) {
			if(isSelected[idx]) continue;
			
			permutation[cnt] = numbers[idx];
			isSelected[idx] = true;
			
			makePermutation(cnt+1);
			isSelected[idx] = false;
		}
	}

}
