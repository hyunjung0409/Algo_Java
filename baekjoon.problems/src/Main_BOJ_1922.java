// BOJ_1922_네트워크 연결
// https://www.acmicpc.net/problem/1922
// 최소 스패닝 트리 (크루스칼 알고리즘 사용)

import java.io.*;
import java.util.*;

class Info implements Comparable<Info> {
	int v1, v2, c;

	public Info(int v1, int v2, int c) {
		super();
		this.v1 = v1; // 정점1
		this.v2 = v2; // 정점2
		this.c = c; // 간선 가중치
	}

	@Override
	public int compareTo(Info o) {
		return this.c - o.c; // 오름차순 정렬
	}
}

public class Main_BOJ_1922 {

	static int[] root;
	static PriorityQueue<Info> pq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		root = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			root[i] = i;
		}

		pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Info(a, b, c));
		}
		
		long sum = 0;
		while (!pq.isEmpty()) {
			Info Info = pq.poll();

			if (find(Info.v1) != find(Info.v2)) { //대표값이 다르면
				union(Info.v1, Info.v2); //간선으로 합친다
				sum += Info.c;
			}
		}
		System.out.println(sum);
	}// end of main

	private static int find(int x) {
		if (x == root[x])
			return x;
		else
			return root[x] = find(root[x]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		root[x] = y;
	}

}