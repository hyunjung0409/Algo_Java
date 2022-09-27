//다시 풀어야 함

import java.io.*;
import java.util.*;

public class BOJ_17836 {
  static int N, M, T;
  static int[][] map;
  static boolean[][][] visited;
  static int[] dr = { 0, 1, 0, -1 };
  static int[] dc = { 1, 0, -1, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    // 0: 빈 공간, 1: 마법 벽, 2: 그람
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    visited = new boolean[N][M][2]; // 0: 그람 X, 1: 그람 O
    visited[0][0][0] = true;

    int result = bfs();

    System.out.println(result != -1 ? result : "Fail");
  }

  static class Point {
    int r, c, cnt;
    boolean gram;

    public Point(int r, int c, int cnt, boolean gram) {
      this.r = r;
      this.c = c;
      this.cnt = cnt;
      this.gram = gram;
    }
  }

  private static int bfs() {
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(0, 0, 0, false));

    while (!queue.isEmpty()) {
      Point cur = queue.remove();

      // 종료조건
      if (cur.r == N - 1 && cur.c == M - 1) {
        return cur.cnt;
      }

      // 사방탐색
      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        // 범위 안에 있고
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
          // 그람이 없는 경우
          if (!cur.gram) {
            // 방문하지 않았고 빈 공간인 경우
            if (!visited[nr][nc][0] && map[nr][nc] == 0) {
              visited[nr][nc][0] = true; // 방문처리
              queue.add(new Point(nr, nc, cur.cnt + 1, cur.gram)); // 시간(cnt)만 증가시켜 준다
            }
            // 방문하지 않았고 그람을 획득한 경우
            if (!visited[nr][nc][0] && map[nr][nc] == 2) {
              visited[nr][nc][0] = true; // 방문처리
              // 시간 증가, gram 획득 여부를 true로 삽입한다.
              queue.add(new Point(nr, nc, cur.cnt + 1, true));
            }
          } else { // 그람이 있는 경우
            if (!visited[nr][nc][1]) {
              visited[nr][nc][1] = true;
              queue.add(new Point(nr, nc, cur.cnt + 1, cur.gram));
            }
          }
        }
      }
    }

    return -1;
  }

}
