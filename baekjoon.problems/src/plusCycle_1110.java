import java.util.Scanner;

public class plusCycle_1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int n2 = n;
		int cnt = 0;

		do {
			n = ((n % 10) * 10) + (((n % 10) + (n / 10)) % 10);
			cnt++;
		} while (n != n2);
		System.out.println(cnt);

	}

}
