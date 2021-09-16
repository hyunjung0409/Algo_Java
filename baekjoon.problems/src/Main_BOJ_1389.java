
// BOJ_1389_케빈 베이컨의 6단계 법칙 (플로이드_워셜)
// https://www.acmicpc.net/problem/1389

import java.io.*;
import java.util.*;

class userInfo implements Comparable<userInfo>{
	int no, value;

	public userInfo(int no, int value) {
		super();
		this.no = no;
		this.value = value;
	}

	@Override
	public int compareTo(userInfo o) {
		return this.value-o.value;
	}
}

public class Main_BOJ_1389 {

	static int n, m, d[][], user[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = new int[n + 1][n + 1];
		user = new int[n+1];
		
		int max = 999;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					d[i][j] = 0;
				else
					d[i][j] = max;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			d[a][b] = 1;
			d[b][a] = 1;
		}

		floyd();
		
		ArrayList<userInfo> list = new ArrayList<>();
		for (int i = 1; i <=n; i++) {
			int value = 0;
			for (int j = 1; j <=n; j++) {
				value += d[i][j];
			}
			userInfo user = new userInfo(i, value);
			list.add(user);
			value=0;
		}

		Collections.sort(list);
		System.out.println(list.get(0).no);
		
	}

	private static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][k] + d[k][j] < d[i][j])
						d[i][j] = d[i][k] + d[k][j];
				}
			}
		}
	}

}
