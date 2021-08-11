import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {

	static int N, M, R;
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 };// 우 하 좌 상
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int r = 0; r < N; r++) { // 배열 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int S = Math.min(N, M) / 2; // 돌려야 하는 사각형 개수
		
		//R번 회전
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < S; j++) {
				int r=i, c=i;
				int temp = map[r][c];
				
				int dir=0;
				while(dir < 4) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					
					if(nr<i || nc<i || nr>= N-i || nc >=M-i) {
						dir++; //방향 변경
					}else {
						map[r][c] = map[nr][nc];
						r =nr;
						c =nc;
					}
				}
				map[i+1][i] = temp;
			} //S만큼의 사각형 회전
		}//R 반복
		
		sb = new StringBuilder();
		for (int r = 0; r < N; r++) { // 결과 출력
			for (int c = 0; c < M; c++) {
				sb.append(map[r][c] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	} // main close
}