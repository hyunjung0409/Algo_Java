import java.io.*;
import java.util.*;

public class Main_BOJ_2606 {
	
	static int N, M; //정점 개수, 간선 개수
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		} 
		
		boolean visited[] = new boolean[N+1];
		bfs(1, visited);
		
		int result = 0;
		for (int i = 2; i <=N; i++) {
			//System.out.print(visited[i]+" ");
			if(visited[i]) {
				result++;
			}
		}
		System.out.println(result);
	}

	private static void bfs(int v, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for (int temp : list[current]) {
				if(!visited[temp]) {
					queue.offer(temp);
					visited[temp] = true;
				}
			}
		}
	}

}
