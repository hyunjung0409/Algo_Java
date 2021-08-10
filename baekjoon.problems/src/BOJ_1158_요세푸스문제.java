import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); //양의 정수
		int K = Integer.parseInt(st.nextToken()); //K번째 제거
		
		Queue<Integer> q = new LinkedList<>();
		
		//Queue에 N까지의 정수 입력
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		
		//나머지 한개가 남을 때까지 반복
		while(q.size() > 1) {
			//K 앞쪽까지는 빼서 뒤로 삽입
			for (int i = 1; i <= K-1; i++) {
				q.offer(q.poll());
			}
			//K번째일 때, 삭제
			sb.append(q.poll() + ", ");
		}
		sb.append(q.poll() + ">");
	
		System.out.println(sb.toString());
	
	}//main end
}//class end