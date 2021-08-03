

//직각삼각형 모양의 숫자 출력하는 클래스
public class DigitText1 {
	public static void main(String[] args) {
		// 5행 5열의 원리를 이용하여 직각삼각형 모양으로 숫자를 출력한다..
		// 첫햇은 숫자 5개 출력, 주번째 행부터 얖쪽열부터 공백문자를 하나씩 늘려서 출력한다.
		int num=1;
		
		/*for (int i = 0; i < 5; i++) {
			for (int b = 1; b <= i; b++) {
				System.out.printf("%3s", " ");
			}
			for (int s = 5 - i; s > 0; s--) {
				System.out.printf("%3d", num);
				num++;
			}
			System.out.println();
		}*/
		
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (r <= c) {
					System.out.printf("%3d", num);
					num++;
				} else {
					System.out.printf("%3s", " ");
				}
			}
			System.out.println();
		}
	}
}
