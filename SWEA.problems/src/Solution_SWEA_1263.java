// SWEA_1263_사람 네트워크2
// https://swexpertacademy.com/main/solvingProblem/solvingProblem.do

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1263 {
	
	static int n, d[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			d = new int[n][n];
			
			for (int i = 0; i <n; i++) {
				for (int j = 0; j <n; j++) {
					d[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i <n; i++) {
				for (int j = 0; j <n; j++) {
					if(i==j) continue;
					if(d[i][j] == 0)
						d[i][j] = 999999;
				}
			}

			floyd();
			
			int min = Integer.MAX_VALUE;
			for (int i = 0; i <n; i++) {
				int sum = 0;
				for (int j = 0; j <n; j++) {
					if(d[i][j] != 999999) 
						sum+=d[i][j];
				}
				if(sum<min) min = sum;
			}

			sb.append("#"+t+" "+min+"\n");
		}
		System.out.print(sb.toString());
	}

	private static void floyd() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(d[i][k]+d[k][j] < d[i][j])
						d[i][j] = d[i][k]+d[k][j];
				}
			}
		}
	}

}
