import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //학생 수
		int K = Integer.parseInt(st.nextToken()); //한 방에 배정가능한 최대 인원 수
		
		int[][] grade = new int[2][6+1];
		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken()); //성별 ( 0 여, 1 남)
			int Y = Integer.parseInt(st.nextToken()); //학년 1~6
			grade[S][Y]++;
		}
		//System.out.println(Arrays.deepToString(grade));
		
		int cnt=0;
		for (int r = 0; r < 2; r++) {
			for (int c = 1; c <=6; c++) {
				cnt += grade[r][c]/K;
				cnt += (grade[r][c]%K==0)? 0 : 1;
			}
		}
		System.out.println(cnt);
	}
}