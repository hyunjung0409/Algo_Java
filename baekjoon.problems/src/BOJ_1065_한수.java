import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1065_한수 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt=0;
		
		for (int i = 1; i <=n; i++) {
			if(Hansu(i))
				cnt++;
		}
		System.out.println(cnt);
	} //end of main

	private static boolean Hansu(int num) {
		if(num<100) 
			return true; //1~99까지는 한수
		else {
			int num1 = num%10; //1의 자리
			int num2 = num/10%10; //10의 자리
			int num3 = num/100; //100의 자리
			
			if((num3-num2)==(num2-num1)) {
				return true;
			}
		}
		return false;
	}
}
