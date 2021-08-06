import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2669_직사각형네개의합집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 4;
		int[][] map = new int[101][101];

		int sum = 0;
		while (T-- > 0) {
			String str = br.readLine();
			st = new StringTokenizer(str, " ");

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						sum++;
					}
				}
			}
		} // T만큼 반복
		System.out.println(sum);
	}
}
