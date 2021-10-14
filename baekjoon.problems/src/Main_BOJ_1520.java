// BOJ_1520_내리막 길
// https://www.acmicpc.net/problem/1520

// DP 적용 요건
// 1. Overlapping subproblem(중복 부분문제 구조)
//	  큰 문제를 이루는 작은 문제들을 먼저 해결하고 작은 문제들의 최적 해(Optimal Solution)를 이용하여 순환적으로 큰 문제를 해결한다.
//	  이미 해결된 작은 문제들의 해들을 어떤 저장 공간(table)에 저장하고 다시 필요할 때마다 참조하여 중복 계산을 피한다.
// 2. Optimal substructure(최적 부분문제 구조)
//	  최적화의 원칙: 어떤 문제에 대한 해가 최적일 때 그 해를 구성하는 작은 문제들의 해 역시 최적이어야 한다.

// DP 적용 접근 방법 3단계
// 1. 최적해 구조의 특성을 파악: 문제를 부분 문제로 나눈다.
// 2. 최적해의 값을 재귀적으로 정의: 부분 문제의 최적해 값에 기반하여 문제의 최적해 값을 정의한다.
// 3. 상향식 방법으로 최적해의 값을 계산: 가장 작은 부분 문제부터 해를 구한 뒤 테이블에 저장. 저장된 부분 문제의 해를 이용하여 상위 부분 문제의 최적해를 구한다.

//사방탐색 + DP ==> DFS (그래프 탐색) + memo[i][j] ((i, j)에서 (R-1, C-1)에 도달하는 경로의 개수)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1520 {

	static int R, C, map[][], memo[][]; // 세로, 가로, 지도, 메모이제이션( memo[r][c] : (r,c)에서 (R-1,C-1)까지 갈 수 있는 경로의 개수)
	static boolean visited[][]; // 방문 체크
	static int dr[] = { -1, 1, 0, 0 }; // 상하좌우
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		memo = new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) { // map 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		memo[R - 1][C - 1] = 1; // 자기 자신으로 갈 수 있는 경우 ==> 1가지
		dfs(0, 0); // 제일 왼쪽 위 칸부터 dfs 탐색
		//System.out.println(Arrays.deepToString(memo));
		System.out.println(memo[0][0]);

	}

	private static void dfs(int r, int c) {
		if (r == R - 1 && c == C - 1 || visited[r][c]) // 도착점에 도달하거나 이미 방문한 칸인 경우
			return; // 재귀를 빠져나옴

		visited[r][c] = true; // 방문 처리

		for (int d = 0; d < 4; d++) { // 사방 탐색
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && map[r][c] > map[nr][nc]) { // 이동하려는 칸이 범위 안에 있고 내리막 길인 경우
				if (memo[nr][nc] == 0) { // 최적해가 없는 경우
					dfs(nr, nc); // dfs 탐색
					memo[r][c] += memo[nr][nc];
				} else { // 최적해가 있는 경우
					memo[r][c] += memo[nr][nc]; // 최적해 갱신
				}
			}
		}
	}

	private static boolean check(int r, int c) { // 범위 확인
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
