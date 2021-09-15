
// SWEA_3124_최소 스패닝 트리
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb&#
// 크루스칼 알고리즘 (Priority Queue 사용)

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int v1, v2, c;

	public Edge(int v1, int v2, int c) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.c = c;
	}

	@Override
	public int compareTo(Edge o) {
		return this.c - o.c; // 오름차순 정렬
	}
}

public class Solution_SWEA_3124_Kruskal {

	static int V, E, root[];
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수

			root = new int[V + 1];
			// 자기 자신으로 초기화
			for (int i = 1; i <= V; i++) {
				root[i] = i;
			}
			
			// pq에 두 정점, 간선 정보를 오름차순으로 입력
			pq = new PriorityQueue<Edge>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				pq.add(new Edge(a, b, c));
			}

			long sum = 0;
			while (!pq.isEmpty()) {
				Edge edge = pq.poll();

				// find --> 두 정점의 대표값이 다르면
				if (find(edge.v1) != find(edge.v2)) {
					// union --> 두 정점을 간선으로 합친다
					union(edge.v1, edge.v2);
					sum += edge.c;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}// end of main

	private static int find(int x) {
		if (x == root[x])
			return x;
		else
			//경로 압축(Path Compression) find 하면서 만난 모든 값의 대표값을 parent로 만든다.
			return root[x] = find(root[x]);
	}// end of find

	private static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		root[v1] = v2;
	}// end of union

}
