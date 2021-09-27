// BOJ_9375_패션왕 신해빈
// https://www.acmicpc.net/problem/9375

import java.io.*;
import java.util.*;

public class Main_BOJ_9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <=T; t++) {
			//String을 key로, Integer를 value로 가지는 HashMap 생성
			HashMap<String, Integer> hm = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken(); //의상 이름은 필요 없음
				String item = st.nextToken();
				
				//입력 받은 의상 종류가 key로 없을 경우
				if(!hm.containsKey(item)) 
					hm.put(item, 1);
				//입력 받은 의상 종류가 key로 있는 경우
				else 
					//같은 이름을 가진 의상은 존재하지 않으므로, 입력받는 대로 1을 더해줌
					hm.put(item, hm.get(item)+1);
			}

			int result = 1;
			for (int value : hm.values()) {
				result *= value+1; //입지 않는 경우가 있으므로 1 더해줌
			}

			System.out.println(result-1); //모두 입지 않는 경우 제외하고 출력
		}//T 반복

	}

}