import java.util.Scanner;

public class printStar_2439 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			for(int j=n-i; j>0; j--) {
				System.out.printf(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		
	}

}
