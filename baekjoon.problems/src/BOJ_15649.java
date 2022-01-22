import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

public class BOJ_15649 {

	static int numbers[]; // 만들어진 순열을 저장하는 배열
	static boolean isSelected[]; // 1부터 N까지의 숫자 중 순열을 만드는 것에 사용되었는지를 저장하는 배열
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numbers = new int[M];
		isSelected = new boolean[N + 1];

		permutation(0);
	}

	// 각 자리에 모든 수를 대입해보고 사용하지 않은 숫자가 있으면 뽑고 다음 자리로 넘어가는 재귀 함수
	private static void permutation(int cnt) { // cnt : 자리
		// 기저조건
		if (cnt == M) {
			// 만들어진 순열 출력
			for (int j = 0; j < M; j++) {
				System.out.print(numbers[j] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (isSelected[i] == true) // 순열 만들기에 사용된 숫자일 경우,
				continue; // 다음 숫자로 넘어간다.

			// 순열 만들기에 사용된 숫자가 아닐 경우,
			numbers[cnt] = i; // 순열 배열에 저장한다.
			isSelected[i] = true;

			permutation(cnt + 1); // 다음 자리에 모든 숫자를 대입해보기위해 재귀함수 실행.

			isSelected[i] = false; // 순열이 완성되었으면 사용된 숫자를 다시 초기 상태로 설정.
		}
	}
}
