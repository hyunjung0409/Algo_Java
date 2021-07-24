import java.util.Arrays;
import java.util.Scanner;

public class Average_1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		double[] arr = new double[tc];
		
		for(int i=0; i<tc; i++) {
			arr[i]=sc.nextDouble();
		}
		
		Arrays.sort(arr);  //배열 오름차순 정렬
		double max=arr[tc-1];
		
		double result=0;
		for(int i=0; i<tc; i++) {
			result += arr[i];
		}
		result = (result/max)*100/tc;
		
		System.out.println(result);
		
	}

}
