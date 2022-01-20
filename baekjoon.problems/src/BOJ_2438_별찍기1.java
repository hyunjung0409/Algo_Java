import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2438_별찍기1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int n = 1; n <= N; n++) {
			for (int i = 1; i <= n; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
