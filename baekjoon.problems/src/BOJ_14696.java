import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //총 라운드 수
		
		int[][] card = new int [2][5];
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a_num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < a_num; j++) {
				card[0][Integer.parseInt(st.nextToken())] ++;
			}
			
			st = new StringTokenizer(br.readLine());
			int b_num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < b_num; j++) {
				card[1][Integer.parseInt(st.nextToken())] ++;
			}

			for (int j = 4; j >0; j--) {
				if(card[0][j] > card[1][j]) {
					sb.append('A');
					break;
				}else if (card[0][j] < card[1][j]) {
					sb.append('B');
					break;
				}else if(j==1 && card[0][j]==card[1][j]) {
					sb.append('D');
					break;
				}
			}

			for (int j = 0; j < 5; j++) {
				card[0][j]=0;
				card[1][j]=0;
			}
			sb.append("\n");
		}//N close
		
		System.out.print(sb.toString());
	}
}