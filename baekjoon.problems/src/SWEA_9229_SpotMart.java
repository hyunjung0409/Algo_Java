import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); //과자 봉지의 개수
			int M = Integer.parseInt(st.nextToken()); //무게 합 제한
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] arr = new int[N];
			for (int i = 0; i <N; i++) { //과자 배열
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max=-1, temp=0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					temp = arr[i]+arr[j];
					if(temp <= M)
						max = (temp>max)? temp : max;
					else
						continue;
				}
			}

			System.out.println("#"+tc+" "+max);
			
		}//T end
		
	}//main end

}//class end