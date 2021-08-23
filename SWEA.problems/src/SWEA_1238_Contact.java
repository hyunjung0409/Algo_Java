// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE&problemTitle=1238&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
//bfs 사용..
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {

	static int N, start; // 정점 개수, 시작점
	static int[][] adjMatrix; // 인접행렬 (가중치 없음)
	static int[] visited; // 시작점부터 i까지의 횟수. 0이면 미방문.
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			adjMatrix = new int[101][101];
			visited = new int[101];

			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = 1;
			}

			sb.append("#" + tc + " ");
			sb.append(bfs());
			sb.append("\n");
		} // tc close
		
		System.out.print(sb.toString());

	}// main close

	private static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(start); // 시작점
		visited[start] = 1; // 첫 방문

		// 큐가 비어있을 때까지 큐의 가장 앞의 값을 빼고 미방문/인점정접인 값을 다시 큐에 넣는다.
		while (!queue.isEmpty()) {
			int from = queue.poll();

			for (int to = 1; to <= 100; to++) {
				if (visited[to] == 0 // 미방문
						&& adjMatrix[from][to] == 1 // 인접 정점
				) {
					queue.offer(to);
					visited[to] = visited[from] + 1; // cnt++
				}
			}
		}

		// 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람
		int max = 0;
		int result = 0;
		for (int i = 1; i <= 100; i++) {
			if (max <= visited[i]) {
				max = visited[i];
				result = i;
			}
		}

		return result;
	}// bfs close

}// class close