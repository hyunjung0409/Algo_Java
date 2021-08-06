import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T=Integer.parseInt(br.readLine()); //테스트 횟수
		int tc=0;
		while(tc++ < T) {
			int N = Integer.parseInt(br.readLine()); //카드 갯수
			int a=0, b=0;
			if(N%2 == 0) {
				a = N/2;
				b = N/2;
			}else {
				a = N/2+1; //교대로 놓는 쪽에 한 장이 더 들어간다
				b = N/2;
			}
			String[] card1 = new String[a];
			String[] card2 = new String[b];
						
			String str = br.readLine();
			st = new StringTokenizer(str, " ");
			
			//반 나눠서 넣어준다
			for (int i = 0; i < a; i++) {
				card1[i] = st.nextToken();
			}
			for (int i = 0; i < b; i++) {
				card2[i] = st.nextToken();
			}
			
			String[] result = new String[N];
			sb.append("#"+tc+" ");
			for (int i = 0; i < N; i++) {
				if(i%2 == 0) {
					result[i] = card1[i/2];
				}else{
					result[i] = card2[i/2];
				}
				sb.append(result[i]+" ");
			}
			sb.append("\n");
		}//T만큼 반복
		
		System.out.println(sb);
	}
}