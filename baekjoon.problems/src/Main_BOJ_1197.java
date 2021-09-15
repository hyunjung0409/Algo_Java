//BOJ_1197_최소 스패닝 트리
//https://www.acmicpc.net/problem/1197
//크루스칼 알고리즘 (ArrayList 사용 --> Collections.sort())

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	//두 개의 노드, 한 개의 엣지
	int v1, v2, cost;
	
	public Edge(int v1, int v2, int cost) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
	
	//cost 기준으로 오름차순 정렬
	@Override
	public int compareTo(Edge o) {
		return this.cost - o.cost; //오름차순
	/*  if (this.cost < o.cost)
			return -1;
		else if (this.cost == o.cost)
			return 0;
		else
			return 1;
	*/
	}
}

public class Main_BOJ_1197 {

	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	//대표값을 확인. 재귀 사용.
	public static int find(int x) {
		//자기 자신을 대표값으로 가진다.
		if (x == parent[x])
			return x;
		else
			//경로 압축(Path Compression) find 하면서 만난 모든 값의 대표 값을 parent로 만든다.
			return parent[x] = find(parent[x]);
	}
	
	//대표값이 다르면 합침
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y)
				parent[y] = x;
			else
				parent[x] = y;
		}
	}

	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수

		edgeList = new ArrayList<Edge>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(a, b, c));
		}
		
		parent = new int[V+1];
		for (int i = 1; i <V; i++) {
			parent[i] = i;
		}

		Collections.sort(edgeList);
		
		int sum=0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			if(!isSameParent(edge.v1, edge.v2)) {
				sum += edge.cost;
				union(edge.v1, edge.v2);
			}
		}
		System.out.println(sum);
		
	}
}