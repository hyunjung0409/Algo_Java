// BOJ_4485_녹색 옷 입은 애가 젤다지?
// https://www.acmicpc.net/problem/4485

import java.io.*;
import java.util.*;

public class Main_BOJ_4485 {
	static int N, map[][], cost[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) //0 입력 시, 입력 종료
				break;
			
			map = new int[N][N];
			cost = new int[N][N];
			for (int r = 0; r < N; r++) {//map 입력
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					cost[r][c] = Integer.MAX_VALUE/1000;
				}
			}
			sb.append("Problem " + t++ + ": " + bfs() +"\n");
		}
		System.out.print(sb.toString());
	}//main close
	
	static class Point implements Comparable<Point>{
		int r, c, v;

		public Point(int r, int c, int v) {
			super();
			this.r = r;
			this.c = c;
			this.v = v;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.v, o.v);
		}
	}
	
	private static int bfs() {
		Point start = new Point(0, 0, map[0][0]);
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(start);
		cost[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			int cr = cur.r;
			int cc = cur.c;
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(check(nr, nc)) {
					if(cost[nr][nc] > cost[cr][cc]+map[nr][nc]) {
						cost[nr][nc] = cost[cr][cc]+map[nr][nc];
						pq.offer(new Point(nr, nc, cost[nr][nc]));
					}
				}
			}
		}

		return cost[N-1][N-1];
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}