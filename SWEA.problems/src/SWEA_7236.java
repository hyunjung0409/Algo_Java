// SWEA_7236_저수지의 물의 총 깊이 구하기
// https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWlTKTUqCN8DFAVS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_7236 {

	static int T, N;
	static String map[][];
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new String[N][N];
			// 배열 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken();
				}
			}
			// System.out.println(Arrays.deepToString(map));

			int cnt = 0, max = Integer.MIN_VALUE;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c].equals("W")) {
						cnt = 0;
						// 팔방 탐색
						for (int dir = 0; dir < 8; dir++) {
							int nr = r + dr[dir];
							int nc = c + dc[dir];

							// 범위 안일 경우
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								if (map[nr][nc].equals("W"))
									cnt++;
							}
						}
					}
					max = Math.max(max, cnt);
				}
			}
			if (max == 0) {
				max = 1;
			}
			sb.append("#" + tc + " " + max + "\n");

		} // T close
		System.out.println(sb.toString());
	}
}