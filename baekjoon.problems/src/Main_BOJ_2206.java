
// BOJ_2206_벽 부수고 이동하기
// https://www.acmicpc.net/problem/2206

import java.io.*;
import java.util.*;

public class Main_BOJ_2206 {
	static int N, M, result;
	static int[][] map, visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}

		result = 0;
		bfs(0, 0);

		//벽을 한 번 이상 부셔야 해서 도착점에 도착하지 못한 경우
		if (result == 0) 
			System.out.println(-1);
		else
			System.out.println(result);
	}

	static class Point {
		int r, c, wall, distance; //r, c 좌표, 부신 벽의 개수, 이동 거리

		public Point(int r, int c, int wall, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.wall = wall;
			this.distance = distance;
		}
	}

	private static void bfs(int r, int c) {
		Point start = new Point(0, 0, 0, 1);
		Queue<Point> q = new LinkedList<>();
		visited[0][0] = 0;
		q.offer(start);

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int cr = cur.r;
			int cc = cur.c;
			int cw = cur.wall;
			int cd = cur.distance;
			
			//도착하면 탈출
			if (cr == N - 1 && cc == M - 1) {
				result = cd;
				break;
			}
			
			for (int d = 0; d < 4; d++) { //사방 탐색
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				//좌표가 범위 안에 있고 방문하지 않은 경우
				if (check(nr, nc) && visited[nr][nc] > cw) {
					if (map[nr][nc] == 0) { // 벽이 아닐 때
						visited[nr][nc] = cw;
						q.offer(new Point(nr, nc, cw, cd + 1));
					} else { // 벽일 때
						if (cw == 0) { //벽을 부시는 것이 처음일 때만 진행
							visited[nr][nc] = cw + 1;
							q.offer(new Point(nr, nc, cw + 1, cd + 1));
						}
					}
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
