import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M_1 {
	static int N, R;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		numbers = new int[R];
		isSelected = new boolean[N+1];

		permutation(0);
		
	}

	private static void permutation(int cnt) {
		//가능한 수를 다 뽑았을 때
		if(cnt == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		//가능한 모든 수 시도
		for (int i = 1; i <= N; i++) {
			//isSelected가 true이라면 (이미 뽑힌 숫자라면)
			if(isSelected[i]) continue;
			
			//이미 뽑힌 수가 아니라면 자리에 해당 숫자를 넣어준다
			numbers[cnt] = i;
			isSelected[i] = true;
			
			//다음 자리 순열을 뽑으러 gogo!
			permutation(cnt+1);
			isSelected[i] = false;
		}
			
	}
}
