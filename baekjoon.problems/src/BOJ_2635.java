// BOJ_2635_수 이어가기
// https://www.acmicpc.net/problem/2635

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2635 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<Integer> result = new ArrayList<>();

		// num/2 이하 값이 오면 4번째 값이 음수가 되므로 제외
		for (int i = num / 2; i <= num; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(num);
			list.add(i);
			while (true) {
				int a = list.get(list.size() - 2);
				int b = list.get(list.size() - 1);

				if (a - b >= 0)
					list.add(a - b);
				else
					break;
			}
			if (list.size() > result.size()) {
				result.clear();
				for (int j = 0; j < list.size(); j++) {
					result.add(list.get(j));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(result.size() + "\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + " ");
		}

		System.out.print(sb.toString());
	}// main close
}