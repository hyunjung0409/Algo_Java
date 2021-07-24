import java.util.Scanner;

public class MinMax_10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		int min = 1000000, max = -1000000;
		int[] arr = new int[t];

		for (int i = 0; i < t; i++) {
			arr[i] = sc.nextInt();
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println(min + " " + max);

	}

}
