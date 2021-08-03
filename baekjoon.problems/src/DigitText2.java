

//모래시계 모양의 숫자 출력하는 클래스
public class DigitText2 {
	public static void main(String[] args) {
		int num = 1;
		int blank=0;
		int row = 5;
		
		
		while (num <= 17) {
			for (int i = 0; i < row; i++) {
				for(int j=0; j<row-blank; j++)
				{
					if(j<blank) {
						System.out.printf("%3s", " ");
					}
					else {
						System.out.printf("%3d",num++);
					}
				}

				if (i < row / 2)
					blank++;
				else
					blank--;
				System.out.println();
			}
		}
	}
}
