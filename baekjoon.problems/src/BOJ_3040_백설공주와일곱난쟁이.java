import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3040_백설공주와일곱난쟁이 {
	static int N=9, R=7;
	static int[] input = new int[N];
	static int[] seven = new int[R];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i <N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		} //아홉 난쟁이 입력

		combination(0,0);
	}//main close

	private static void combination(int cnt, int start) {
		if(cnt == R) { //7명을 모두 뽑았을 때
			int total = 0;
			for (int i = 0; i < seven.length; i++) 
				total += seven[i]; //모두 더해준다
			if(total == 100) {	   //total이 100이면 출력
				for (int i = 0; i < seven.length; i++)
					System.out.println(seven[i]);
			}
			return;
		}
			
		for (int i = start; i < N; i++) {
			seven[cnt] = input[i];
			combination(cnt+1, i+1); //중복을 피함
		}

	}//combination close
	
}//class close