import java.util.Scanner;

public class remainder_3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] arr=new boolean[42];
		
		for(int i=0; i<10; i++) {
			arr[sc.nextInt()%42] = true;
		}
		
		int cnt=0;
		for(int i=0; i<42; i++) {
			if(arr[i] == true)
				cnt++;
		}
		System.out.println(cnt);
	}

}
