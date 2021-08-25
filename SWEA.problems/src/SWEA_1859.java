// SWEA_1859_백만 장자 프로젝트
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <=T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			
			//매매가 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int max=arr[N];
			long result=0;
			for (int j = N-1; j>0; j--) {
				if(max - arr[j]>0) {
					result += max - arr[j];
				}else if(max - arr[j]<0) {
					max = arr[j];
				}
			}

			sb.append("#"+i+" "+result+"\n");
		}//T close
		System.out.print(sb.toString());
	}
}