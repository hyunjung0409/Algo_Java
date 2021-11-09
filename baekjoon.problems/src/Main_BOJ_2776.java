// BOJ_2776_암기왕
// https://www.acmicpc.net/problem/2776

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BOJ_2776 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			//HashSet : Set은 객체를 중복해서 저장할 수 없고 저장 순서가 유지되지 않는다.
			// --> 중복을 자동으로 제거해줌
			HashSet<Integer> hset = new HashSet<>();
			for (int i = 0; i < N; i++) {
				hset.add(Integer.parseInt(st.nextToken()));
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				int num2 = Integer.parseInt(st.nextToken());
				//HashSet 값 검색 : contatins(value) 메소드 사용
				//파라미터로 주어진 객체가 HashSet에 있다면 true, 없으면 false를 반환
				if (hset.contains(num2)) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}