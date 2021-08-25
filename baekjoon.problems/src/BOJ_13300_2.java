// BOJ_13300_방배정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13300_2 {
	public static void main(String[] args) throws IOException {
		//0 여학생   1 남학생
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //학생 수
		int K = Integer.parseInt(st.nextToken()); //한 방 최대 인원
		
		int[][] room = new int[2][6+1];		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken()); //성별
			int y = Integer.parseInt(st.nextToken()); //학년
			
			room[s][y]++;
		}
		//System.out.println(Arrays.deepToString(room));
		
		int cnt=0;
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <=6; j++) {
				if(room[i][j]%K == 0) {
					cnt+=room[i][j]/K;
				}else if(room[i][j]%K != 0) {
					cnt= cnt + room[i][j]/K +1;
				}
			}
		}
		System.out.println(cnt);
	}
}
