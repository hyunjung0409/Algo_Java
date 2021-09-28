// BOJ_1269_대칭 차집합
// https://www.acmicpc.net/problem/1269

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BOJ_1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> hm = new HashMap<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < A; i++) {
			int t = Integer.parseInt(st.nextToken());
			hm.put(t, t);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < B; i++) {
			int t = Integer.parseInt(st.nextToken());
			if (!hm.containsKey(t))
				hm.put(t, t);
			else
				hm.remove(t, t);
		}
		System.out.println(hm.size());
		/*----------------------------------------------
 		HashMap<Integer, Integer> a = new HashMap<>();
		HashMap<Integer, Integer> b = new HashMap<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < A; i++) {
			int t = Integer.parseInt(st.nextToken());
				a.put(t, t);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < B; i++) {
			int t = Integer.parseInt(st.nextToken());
				b.put(t, t);
		}

		int cnt = 0;
		for(int a_key : a.keySet()) {
			if(!b.containsKey(a_key))
				cnt++;
		}
		for(int b_key : b.keySet()) {
			if(!a.containsKey(b_key))
				cnt++;
		}
		System.out.println(cnt);
		-----------------------------------------------*/
		
	}//main close

}