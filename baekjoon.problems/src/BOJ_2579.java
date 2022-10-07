import java.io.*;

public class BOJ_2579 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int stair = Integer.parseInt(br.readLine());
    int[] arr = new int[stair + 1];
    for (int i = 1; i <= stair; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[stair + 1];
    dp[1] = arr[1];
  }

}