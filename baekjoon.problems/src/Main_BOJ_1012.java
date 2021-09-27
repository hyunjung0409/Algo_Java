// BOJ_1012_유기농 배추
// https://www.acmicpc.net/problem/1012

import java.io.*;
import java.util.*;

class Position{
	int r, c;

	public Position(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class Main_BOJ_1012 {

	static int M, N, K; //가로 길이, 세로 길이, 위치 개수
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M][N];
			visited = new boolean[M][N];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						cnt++;
						bfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
	}//end of main

	private static void bfs(int r, int c) {
		Queue<Position> queue = new LinkedList<>();
		Position p = new Position(r, c);
		queue.offer(p);
		
		while(!queue.isEmpty()) {
			Position t = queue.poll();
			visited[t.r][t.c] = true;
			
			for (int i = 0; i <4; i++) {
				int nr = t.r+dr[i];
				int nc = t.c+dc[i];
				if(nr>=0 && nr<M && nc>=0 && nc<N) {
					if(map[nr][nc] == 1 && !visited[nr][nc]) {
						Position t2 = new Position(nr, nc);
						queue.offer(t2);
						visited[t2.r][t2.c] = true;
					}
				}
			}
		}
	}//end of bfs

}
