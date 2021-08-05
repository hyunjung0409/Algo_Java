//스택에 '{', '[', '<', '(' 담기 --> '}', ']', '>', ')' 나오면 peek해서 짝인지 비교
//짝이면 pop.

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) throws Exception, IOException {
		//System.setIn(new FileInputStream("input_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int tc = 0;

		while (tc++ < T) {
			int size = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> st = new Stack<>();

			for (int i = 0; i < size; i++) {
				char temp = str.charAt(i);
				if (temp == '}' && st.peek() == '{') {
					st.pop();
				} else if (temp == ']' && st.peek() == '[') {
					st.pop();
				} else if (temp == '>' && st.peek() == '<') {
					st.pop();
				} else if (temp == ')' && st.peek() == '(') {
					st.pop();
				} else { // '{', '[', '<', '(' 면 담기
					st.push(temp);
				}
			}// size만큼 반복
			
			int result;
			if(st.isEmpty())
				result = 1;
			else
				result = 0;
			System.out.println("#"+tc+" "+result);
		}// T만큼 반복 
	}// end of main
}
