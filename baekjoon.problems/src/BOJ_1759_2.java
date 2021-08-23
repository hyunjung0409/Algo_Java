//https://www.acmicpc.net/problem/1759
//암호 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_2 {

	static int L; // 암호로 사용된 서로 다른 알파벳 소문자 갯수
	static int C; // 암호로 사용했을 법한 문자의 종류
	static char[] pswd, list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		pswd = new char[L];
		list = new char[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			char alpha = st.nextToken().charAt(0);
			list[i] = alpha;
		}

		Arrays.sort(list);

		comb(0, 0, 0, 0);
		System.out.print(sb.toString());
	}// main close

	// cnt: 현재까지 뽑은 조합 원소 개수
	// start: 조합 시도할 원소의 시작 알파벳
	private static void comb(int cnt, int start, int v, int c) {
		if (cnt == L) {// 조합 생성 완료
			if (v >= 1 && c >= 2) { //최소 한 개의 모음, 두 개의 자음
				for (int i = 0; i < L; i++) {
					sb.append(pswd[i]);
				}
				sb.append("\n");
			}
			return;
		}

		// start부터 가능한 모든 수 고려
		for (int i = start; i < C; i++) {
			pswd[cnt] = list[i];
			
			if (list[i] == 'a' || list[i] == 'e' || list[i] == 'i' || list[i] == 'o'
					|| list[i] == 'u')
				comb(cnt + 1, i + 1, v + 1, c);
			else
				comb(cnt + 1, i + 1, v, c + 1);
		}
	}// comb close
}