// BOJ_1261_알고스팟
// https://www.acmicpc.net/problem/1261

import java.io.*;
import java.util.*;

public class Main_BOJ_1261_2 {
	static int M, N, map[][],cnt[][]; // 가로, 세로, 미로, 벽 카운트
	static int dr[] = { -1, 0, 1, 0 }; // 상우하좌
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cnt = new int[N][M];
		// map 입력 (0: 빈 방, 1: 벽)
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				cnt[i][j] = Integer.MAX_VALUE/1000;
			}
		}
		// System.out.println(Arrays.deepToString(map));
		System.out.println(bfs());
	}
	
	static class Point implements Comparable<Point>{
		int r, c, w;

		public Point(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) { //0, 1 비교 (빈 방을 우선으로 가도록)
			return Integer.compare(this.w, o.w);
		}
	}

	private static int bfs() {
		Point start = new Point(0, 0, 0);
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(start);
		cnt[0][0] = map[0][0];

		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			int cr = cur.r;
			int cc = cur.c;

			//사방탐색
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (check(nr, nc)) {
					if(cnt[nr][nc] > cnt[cr][cc] + map[nr][nc]) {
						cnt[nr][nc] = cnt[cr][cc] + map[nr][nc];
						pq.offer(new Point(nr, nc, cnt[nr][nc]));
					}
				}
			}
		}
		return cnt[N-1][M-1];
	}
	
	//map 범위인지 확인
	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}