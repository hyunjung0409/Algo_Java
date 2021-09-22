//BOJ_1260_DFS와 BFS
//https://www.acmicpc.net/problem/1260

import java.io.*;
import java.util.*;

public class Main_BOJ_1260 {

	static int N, M, V; // 정점 개수, 간선 개수, 탐색 시작 정점
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		
		for (int i = 1; i <=N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		for (int i = 1; i <=N; i++) {
			Collections.sort(list[i]);
		}

		boolean[] visited = new boolean[N+1];
		dfs(V, visited);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V, visited);
	}

	private static void bfs(int v, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");

			for(int temp : list[current]) {
				if(!visited[temp]) {
					queue.offer(temp);
					visited[temp] = true;
				}
			}
		}
	}

	private static void dfs(int v, boolean[] visited) {	
		visited[v] = true;
		System.out.print(v+" ");

		for(int temp: list[v]) {
			if(!visited[temp]) {
				dfs(temp, visited);
			}
		}
	}

}
