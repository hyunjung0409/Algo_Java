// BOJ_11404_플로이드
// https://www.acmicpc.net/problem/11404

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11404 {

	static int n, m, d[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 도시의 개수
		m = Integer.parseInt(br.readLine()); // 버스의 개수
		d = new int[n + 1][n + 1];

		// 최대값으로 인접행렬 초기화
		int max = 99999999; //n 최대 100, 최대 비용 100000
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == j)
					d[i][j] = 0;
				else
					d[i][j] = max;
			}
		}

		// 인접행렬 입력 (최소값만 입력)
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (d[a][b] > c) {
				d[a][b] = c;
			}
		}
		
		floyd();
		
		//최소비용으로 업데이트 된 배열 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=n; j++) {
				if(d[i][j] == max)
					d[i][j] = 0;
				sb.append(d[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
	}//end of main

	public static void floyd() {
		for (int k = 1; k <=n; k++) {
			for (int i = 1; i <=n; i++) {
				for (int j = 1; j <=n; j++) {
					if(d[i][k]+d[k][j] < d[i][j])
						d[i][j] = d[i][k]+d[k][j];
				}
			}
		}
	}//end of floyd

}