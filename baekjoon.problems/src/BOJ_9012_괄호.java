import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class BOJ_9012_괄호 {
	public static void main(String[] args) throws IOException, EmptyStackException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			String str = br.readLine();
			System.out.println(check(str));
		} // T만큼 반복
	}

	private static String check(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);
			if (temp == '(') {
				stack.push(temp);
			} else {
				if (stack.isEmpty()) {
					return "NO";
				} else {
					stack.pop();
				}
			}
		} // size만큼 반복

		if (stack.isEmpty())
			return "YES";
		else
			return "NO";
	}
}