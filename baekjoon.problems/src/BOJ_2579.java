import java.io.*;

public class BOJ_2579 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int stair = Integer.parseInt(br.readLine());
		
		int[] arr = new int[stair+1];
		for (int i = 1; i <= stair; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[stair+1];
		dp[1] = arr[1];
		
		if(stair >= 2)
			dp[2] = arr[1] + arr[2];
		
		for (int i = 3; i <= stair; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
		}
		
		System.out.println(dp[stair]);

}