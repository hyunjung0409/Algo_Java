import java.io.*;
import java.util.*;

public class BOJ_2667 {

  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int[] dr = { 0, 1, 0, -1 };
  static int[] dc = { 1, 0, -1, 0 };
  static ArrayList<Integer> list = new ArrayList();

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }

    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 && !visited[i][j])
          bfs(i, j);
      }
    }

    System.out.println(list.size());

    Collections.sort(list);

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  static class Apt {
    int r, c;

    public Apt(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  private static void bfs(int r, int c) {
    Queue<Apt> queue = new LinkedList<>();
    visited[r][c] = true;
    queue.add(new Apt(r, c));

    int cnt = 0;
    while (!queue.isEmpty()) {
      Apt cur = queue.remove();
      cnt++;

      for (int i = 0; i < 4; i++) {
        int nr = cur.r + dr[i];
        int nc = cur.c + dc[i];

        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
          if (map[nr][nc] == 1 && !visited[nr][nc]) {
            visited[nr][nc] = true;
            queue.add(new Apt(nr, nc));
          }
        }
      }
    }

    list.add(cnt);
  }

}
