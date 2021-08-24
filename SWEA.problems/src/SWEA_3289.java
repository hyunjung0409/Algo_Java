//SWEA_3289_서로소집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {

	static int n, m; // n: a,b 는 n 이하의 자연수. 같을 수도 있음. m: m개 줄 입력
	static int[] parents; // 부모원소를 관리 (트리처럼 사용)
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			parents = new int[n+1];
			
			make();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int type = Integer.parseInt(st.nextToken()); // 0: 합집합 1: 같은 집합인지 확인
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				switch (type) {
				case 0:
					union(a, b);
					break;
				case 1:
					if(find(a) == find(b))
						sb.append(1);
					else
						sb.append(0);
					break;
				}

			}
			sb.append("\n");
		} // tc close
		
		System.out.print(sb.toString());

	} // main close
	
	
	private static void make() {
		// 모든 원소를 자신의 대표자로 만듦
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	} // make close
	
	private static int find(int a) {// a가 속한 집합의 대표자 찾기
		if (a == parents[a])
			return a; // 자기 자신이 대표자인 경우
		
		// 자신이 속한 집합의 대표자를 자신의 부모로 --> path compression
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {// 두 원소를 하나의 집합으로 합치기 (대표자 합침)
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 이미 같은 집합인 경우 합치지 않음
		if (aRoot == bRoot)
			return false;
		
		// 대표자끼리 합친다
		parents[bRoot] = aRoot; // b를 a에 붙인다
		return true;
	}
}