// J_1037_오류교정
// http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=316

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J_1037 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][N + 1];
		int[] row = new int[N + 1];
		int[] col = new int[N + 1];

		// 행렬 입력
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// System.out.println(Arrays.deepToString(arr));

		// 행, 열 원소를 일차원 배열에 누적
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				row[r] += arr[r][c];
				col[c] += arr[r][c];
			}
		}
		//System.out.println(Arrays.toString(row));
		//System.out.println(Arrays.toString(col));

		// 일차원 배열 탐색
		int r = 0;
		int c = 0;
		int r_cnt = 0;
		int c_cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (row[i] % 2 != 0) {
				r = i;
				r_cnt++;
			}
			if (col[i] % 2 != 0) {
				c = i;
				c_cnt++;
			}

		}
		
		//출력
		if (r == 0 && c == 0 && r_cnt == 0 && c_cnt == 0) {
			System.out.print("OK");
		}
		if (r != 0 || c != 0) {
			if (r_cnt == 1 && c_cnt == 1) {
				System.out.printf("Change bit (%d,%d)", r, c);
			} else {
				System.out.print("Corrupt");
			}
		}
	}

}