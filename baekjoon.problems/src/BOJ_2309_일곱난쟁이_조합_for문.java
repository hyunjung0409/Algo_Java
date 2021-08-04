//난쟁이 키 20개 -> ArrayList[9]에 저장 및 sum 저장

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2309_일곱난쟁이_조합_for문 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> nine = new ArrayList<>();
		int sum = 0;
		
		//Arraylist에 9개의 입력값을 저장
		for (int i = 0; i < 9; i++) {
			nine.add(Integer.parseInt(br.readLine()));
			sum += nine.get(i);
		}
		
		//두 개 골라서 뺐을 때, 100
		out:
		for (int i = 0; i < nine.size(); i++) {
			int a = nine.get(i);
			for (int j = i+1; j < nine.size(); j++) {
				int b = nine.get(j);
				if(sum -a -b == 100) {
					nine.remove((Integer)a);
					nine.remove((Integer)b);
					break out;//2개 선택 반복문 탈출
				}
			}
		} 
		
		Collections.sort(nine);
		for(int i: nine)
			System.out.println(i);
	}//end of main
}// end of class