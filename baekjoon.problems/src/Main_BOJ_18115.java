// BOJ_18115_카드 놓기
// https://www.acmicpc.net/problem/18115

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_BOJ_18115 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		//입력받은 기술을 뒤에서부터 사용하기 위하여 ArrayList >> reverse()
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.reverse(list);
//		for (int i = 0; i <N; i++) {
//			System.out.print(list.get(i)+" ");
//		}
		
		//사용하는 기술에 따라 앞 혹은 뒤로 넣기 때문에 덱 사용
		//Deque(double-ended queue): 앞과 뒤에서 즉, 양방향에서 데이터를 처리할 수 있는 queue형 자료구조를 의미
		Deque<Integer> dq = new ArrayDeque<>();
		int num = 1; //마지막으로 뽑히는 숫자로 가장 먼저 덱에 넣어줌
		int tmp = 0; //기술 2에서 앞에 숫자를 저장할 변수
		for (int i = 0; i < N; i++) {
			int func = list.get(i);
			
			if(func == 1) { //숫자를 앞에서 넣어줌
				dq.addFirst(num);
			}else if(func == 2) { 
				//덱에 앞에 저장된 숫자를 제거 후 저장
				//현재 숫자를 앞에서 넣고 저장된 숫자를 다시 앞에서 넣어줌
				tmp = dq.remove();
				dq.addFirst(num);
				dq.addFirst(tmp);
			}else { //숫자를 뒤에서 넣어줌
				dq.addLast(num);
			}
			num++; //숫자 증가
		}

		//덱 앞에서부터 출력
		while (!dq.isEmpty()) {
			sb.append(dq.remove()).append(" ");
		}
		System.out.println(sb.toString());
	}
}