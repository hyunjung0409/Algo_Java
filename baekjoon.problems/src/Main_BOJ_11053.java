
// BOJ_11053_가장 긴 증가하는 부분 수열
// https://www.acmicpc.net/problem/1105

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		int[] LIS = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		LIS[0] = num[0];
		int size = 1;
		for (int i = 1; i < n; i++) {
			if (LIS[size - 1] < num[i]) // 이전 값보다 큰 값이 들어오면
				LIS[size++] = num[i]; // LIS 배열에 붙인다
			else if (LIS[0] > num[i])
				LIS[0] = num[i]; // 최소값으로 갱신
			else {
				int temp =Arrays.binarySearch(LIS, 0, size, num[i]);
				LIS[temp<0? Math.abs(temp)-1 : temp] = num[i];
			}
		}

		System.out.println(size);
	}

}
