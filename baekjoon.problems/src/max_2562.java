import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class max_2562 {

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine(), ""); //한줄 입력 받아서 자르는 것
		int[] arr = new int[9];
		int max=0, idx=0;
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max<arr[i]) {
				max=arr[i];
				idx=i+1;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}
}
