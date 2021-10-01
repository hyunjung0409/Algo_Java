
// BOJ_7576_토마토
// https://www.acmicpc.net/problem/7576

import java.io.*;
import java.util.*;

public class Main_BOJ_7576 {

	static class Point {
		int r, c, day;

		public Point(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}

	static int M, N, green, result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<Point> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		map = new int[N][M];
		visited = new boolean[N][M];

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) { //익은 토마토면 list에 추가
					list.add(new Point(i, j, 0));
				} else if (map[i][j] == 0) { //익지 않은 토마토면 count
					green++;
				}
			}
		}
		if (green == 0) //익지 않은 토마토가 없으면
			System.out.println(0); //0 출력
		else
			System.out.println(bfs());

	} // end of main

	private static int bfs() {
		Queue<Point> q = new LinkedList<>();
		//익은 토마토 개수만큼 start 객체를 생성
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i).r;
			int c = list.get(i).c;
			Point start = new Point(r, c, 1); 
			visited[r][c] = true;
			q.offer(start);
		}

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int cr = cur.r;
			int cc = cur.c;
			int cd = cur.day;

			for (int d = 0; d < 4; d++) { //사방탐색
				//이동할 좌표
				int nr = cr + dr[d];
				int nc = cc + dc[d];

				if (check(nr, nc) && !visited[nr][nc]) {
					//토마토가 들어있지 않은 칸일 경우
					if (map[nr][nc] == -1)
						continue;
					//익지 않은 토마토가 있는 칸일 경우
					else if (map[nr][nc] == 0) {
						visited[nr][nc] = true;
						map[nr][nc] = 1; //익은 토마토 처리
						green -= 1; //익지 않은 토마토 수 -1
						//토마토가 다 익은 경우
						if (green == 0) {
							//익기까지의 기간
							return cd;
						}
						//이동할 좌표, 날짜+1 해서 큐에 넣어준다
						q.offer(new Point(nr, nc, cd + 1));
					}
				}
			}
		}
		return -1;
	}// end of bfs

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

} // end of class