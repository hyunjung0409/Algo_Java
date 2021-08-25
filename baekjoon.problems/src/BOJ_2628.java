// BOJ_2628_종이자르기
// https://www.acmicpc.net/problem/2628

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2628 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		List<Integer> list_r = new ArrayList<>();
		List<Integer> list_c = new ArrayList<>();

		list_r.add(0);
		list_c.add(0);

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int cut = Integer.parseInt(br.readLine());
		for (int i = 0; i < cut; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (type == 0) {
				list_r.add(num);
			} else {
				list_c.add(num);
			}
		}

		list_r.add(h);
		list_c.add(w);

		Collections.sort(list_r); // 0 2 3 8
		Collections.sort(list_c); // 0 4 10

		int max = 0;

		for (int i = list_r.size() - 1; i > 0; i--) {
			int r = list_r.get(i) - list_r.get(i - 1);
			for (int j = list_c.size() - 1; j > 0; j--) {
				int c = list_c.get(j) - list_c.get(j - 1);
				int temp = r * c;
				max = Math.max(max, temp);
			}
		}
		System.out.println(max);
	}
}