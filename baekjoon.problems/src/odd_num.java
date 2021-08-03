
import java.util.Scanner;

public class odd_num {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		int t = 0;
		int result = 0;
		
		while(t++ <tc) {
			for(int i=0; i<10; i++) {
				int num = sc.nextInt();
				if(num%2 != 0) { //홀수이면
					result += num; //더한다
				}
			}
			System.out.println("#"+(t+1)+" "+result);
			
			result = 0;
		}
	}
}
