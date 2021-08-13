import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5432_쇠막대기자르기 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); //ctrl+1 -> enter --> throws
		int tc = 0;
		while(tc++ < T) {
			String str = br.readLine(); //괄호 문자열 읽어옴			
			str = str.replace("()", "v"); //레이저 두글자() 표시를 한글자 표시로 변경
			
			int cnt=0; //현재 바닥에 놓여있는 쇠막대기 개수
			int sum=0; //레이저로 쪼개지는 쇠막대기의 총 개수
			
			for (int j = 0; j < str.length(); j++) { //switch문이 더 빠를 수 있다.
				if(str.charAt(j) == 'v') { //레이저라면 sum += cnt
					sum += cnt;
				}
				else if(str.charAt(j) == '(') { // 시작 괄호, cnt++
					cnt++;
				}
				else { //닫는 괄호, sum++, cnt--
					sum++; cnt--;
				}
			} //str 길이만큼 반복

			sb.append("#"+tc+" "+sum+"\n");
		}//T만큼 반복
		System.out.print(sb);
	}// end of main
}