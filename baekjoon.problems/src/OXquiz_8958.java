import java.util.Scanner;

public class OXquiz_8958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < tc; i++) {
			String str = sc.nextLine();
			int cnt = 0, score = 0;

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'O') {
					cnt++;
					score += cnt;
				} else if (str.charAt(j) == 'X') {
					cnt = 0;
				}
			}
			System.out.println(score);

		}

	}

}
