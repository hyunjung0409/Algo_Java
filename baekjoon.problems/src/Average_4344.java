import java.util.Scanner;

public class Average_4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] arr;
		
		for(int i=0; i<tc; i++) {
			int n = sc.nextInt();
			arr=new int[n];
			double sum=0, count=0;  //int 아닌 double 사용
			
			for(int j=0; j<n; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}
			
			for(int j=0; j<n; j++) {
				if(arr[j]>(sum/n)) {
					count++;
				}
			}
			
			System.out.printf("%.3f", (count/n) * 100);
			System.out.print("%\n");
			
		}

	}

}
