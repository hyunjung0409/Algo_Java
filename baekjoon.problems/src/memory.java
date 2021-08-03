
import java.util.Scanner;

public class memory {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt(); //테스트 횟수 입력

		for (int t = 1; t <= tc; t++) {

			String str = sc.next(); //메모리 입력
			char[] origin = new char[str.length()]; //원래 메모리
			char[] memory = new char[str.length()]; //초기화 된 메모리
			int count = 0;

			for (int i = 0; i < str.length(); i++) {
				origin[i] = str.charAt(i);
				memory[i] = '0';
			}

			for (int i = 0; i < str.length(); i++) { //배열 처음부터 끝까지 확인
				if (origin[i] != memory[i]) { 

					for (int j = i; j < str.length(); j++) { //i부터 배열 끝까지 값이 떺어씌워진다.
						memory[j] = origin[i];
					}
					count++;
				}
			}
			System.out.println("#" + t + " " + count);

		}

	}
}