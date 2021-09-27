// BOJ_1755_숫자놀이
// https://www.acmicpc.net/problem/1755

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class numAlphabet implements Comparable<numAlphabet>{
	int num;
	String alphabet;
	
	public numAlphabet(int num, String alphabet) {
		super();
		this.num = num;
		this.alphabet = alphabet;
	}
	
	@Override
	public int compareTo(numAlphabet o) {
		return this.alphabet.compareTo(o.alphabet);
	}
}

public class Main_BOJ_1755 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(0, "zero");
		hm.put(1, "one");
		hm.put(2, "two");
		hm.put(3, "three");
		hm.put(4, "four");
		hm.put(5, "five");
		hm.put(6, "six");
		hm.put(7, "seven");
		hm.put(8, "eight");
		hm.put(9, "nine");

		PriorityQueue<numAlphabet> pq = new PriorityQueue<>();
		for (int i = M; i <=N; i++) {
			if(i/10 != 0) { //두자리 수일 경우,
				String alpha1 = hm.get(i/10);
				String alpha2 = hm.get(i%10);
				numAlphabet t = new numAlphabet(i, alpha1+" "+alpha2);
				pq.add(t);
			}
			else { //한자리 수일 경우,
				String alpha1 = hm.get(i%10);
				numAlphabet t = new numAlphabet(i, alpha1);
				pq.add(t);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		while(!pq.isEmpty()) {
			sb.append(pq.poll().num + " ");
			cnt++;
			if (cnt % 10 == 0)
				sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
