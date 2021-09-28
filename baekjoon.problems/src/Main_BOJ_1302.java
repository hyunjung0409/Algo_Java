
// BOJ_1302_베스트셀러
// https://www.acmicpc.net/problem/1302

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main_BOJ_1302 {

	static class Book implements Comparable<Book> {
		String bookTitle;
		int value;

		public Book(String bookTitle, int value) {
			super();
			this.bookTitle = bookTitle;
			this.value = value;
		}
		//가장 많이 팔린 책이 여러 개일 경우, 
		//사전 순으로 가장 앞서는 제목을 출력하기 위해 오름차순으로 정렬
		@Override
		public int compareTo(Book o) {
			return this.bookTitle.compareTo(o.bookTitle);
		}
	}//Book close

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//책 제목을 key로 가지는 hashMap 생성
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String title = br.readLine();
			if (!hm.containsKey(title)) {
				hm.put(title, 1);
			} else {
				hm.put(title, hm.get(title) + 1);
			}
		}
		//key마다 key, value를 가지는 객체를 생성 -> pq에 저장
		PriorityQueue<Book> pq = new PriorityQueue<>();
		for (String key : hm.keySet()) {
			Book book = new Book(key, hm.get(key));
			pq.add(book);
		}
		// value 중 가장 많이 팔린 책 탐색
		int result = 0;
		for (Integer cnt : hm.values()) {
			result = result < cnt ? result = cnt : result;
		}
		//result 값과 같은 value를 가지는 Book 객체 탐색 -> 해당 객체의 title 출력
		while (!pq.isEmpty()) {
			Book temp = pq.poll();
			if (temp.value == result) {
				System.out.println(temp.bookTitle);
				break;
			}
		}
	}// main close

}