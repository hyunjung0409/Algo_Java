import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {
	static int N, numbers[];
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		isSelected = new boolean[N+1];
		
		permutation(0);
	}

	private static void permutation(int cnt) {
		if(cnt==N) {
			for (int i = 0; i < N; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
		}
		
		for (int i = 1; i <=N; i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			permutation(cnt+1);
			isSelected[i] = false;
		}	
	}
}