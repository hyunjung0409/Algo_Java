//BOJ_12738_가장 긴 증가하는 부분 수열 3
//https://www.acmicpc.net/problem/12738

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_12738 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		int[] LIS = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0;
		for (int i = 0; i < n; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, num[i]);
			if (temp >= 0)
				continue;
			temp = Math.abs(temp)-1;
			LIS[temp] = num[i];
			
			if(temp==size)
				size++;
		}
		System.out.println(size);
	}

}
