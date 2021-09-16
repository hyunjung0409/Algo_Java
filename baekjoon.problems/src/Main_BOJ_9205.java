//BOJ_9205_맥주 마시면서 걸어가기 (플루이드-워셜)
//https://www.acmicpc.net/problem/9205

import java.io.*;
import java.util.*;

class Point {
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main_BOJ_9205 {

	static int N, D[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine()); // 편의점 개수
			D = new int[N + 2][N + 2]; // 초기 인접행렬 --> 최소 비용으로 업데이트
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					D[i][j] = 999999; // 최대 편의점 100 * 맥주 20병 * 50미터 ??
				}
			}

			// 정점 입력 -> 리스트에 저장
			ArrayList<Point> list = new ArrayList<>();
			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Point(x, y));
			}
			
			//정점 간의 거리가 1000 이하일 경우 1로 업데이트
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					if (i == j)
						continue;
					Point current = list.get(i);
					Point next = list.get(j);

					int distance = Math.abs(current.x - next.x) + Math.abs(current.y - next.y);
					if (distance <= 1000)
						D[i][j] = 1;
				}
			}
			
			floyd(); //최소값으로 업데이트
			
			//도착점 값이 최소값으로 업데이트 --> 도착 가능
			if (0 < D[0][N + 1] && D[0][N + 1] < 999999)
				sb.append("happy"+"\n");
			else
				sb.append("sad"+"\n");
			
		}//T 반복
		
		System.out.print(sb.toString());
	}// end of main

	private static void floyd() {
		for (int k = 0; k < N + 2; k++) { //경유지
			for (int i = 0; i < N + 2; i++) { //출발점
				for (int j = 0; j < N + 2; j++) { //도착점
					if (D[i][k] + D[k][j] < D[i][j]) //경유지를 거쳐서 가는 것이 최소면
						D[i][j] = D[i][k] + D[k][j]; //업데이트
				}
			}
		}
	}//end of floyd

}