import java.io.*;
import java.util.*;

public class BOJ_2667 {

	static int N;
	static int[][] apt;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		apt = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				apt[i][j] = str.charAt(j) - '0';
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(apt[i][j]);
//			}
//			System.out.println();
//		}
		
		visited = new boolean[N][N];
		
		
	}

}
