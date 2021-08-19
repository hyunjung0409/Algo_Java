//LinkedList
//N 입력받으면 그만큼의 배열 만들고 번호를 저장한다. add할 때는 LinkedList size-번호 ..?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2605 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N]; //학생들이 뽑은 숫자를 저장할 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}//배열에 숫자 저장
		//System.out.println(Arrays.toString(num));
		
		List<Integer> list = new LinkedList<>();
		
		list.add(1); //첫번째 학생 저장
		for (int i = 2; i <= N; i++) { //2번째 학생부터 N까지 학생까지
			list.add(list.size()-num[i-1], i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)+" ");
		}
		
		System.out.print(sb.toString());
	}
}