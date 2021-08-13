import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) throws Exception, IOException {
		//System.setIn(new FileInputStream("input_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T= Integer.parseInt(br.readLine());
		int tc=0;
		while(tc++ <T) {
			String str = br.readLine();
			st = new StringTokenizer(str, " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			//배열에 파리 수 입력
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String fly = br.readLine();
				st = new StringTokenizer(fly, " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
				//System.out.println(Arrays.deepToString(map));
			
			int max=0; 
			
			for(int nr=0; nr<N-M+1; nr++) {
				for(int nc=0; nc<N-M+1; nc++) {
					int sum=0; //열마다 초기화
					for(int mr=0; mr<M; mr++) {
						for(int mc=0; mc<M; mc++) {
							sum += map[nr+mr][nc+mc];
						}//M열
					}//M행
					if(max < sum) {
						max = sum;
					}
				}//N열
			}//N행
			System.out.println("#"+tc+" "+max);
		} //T만큼 반복
		
	}//end of main
}