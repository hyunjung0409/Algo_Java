
// BOJ_20055_컨베이어 벨트 위의 로봇
// https://www.acmicpc.net/problem/20055

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_20055 {

	static int N, K;
	static int[] belt;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 길이
		K = Integer.parseInt(st.nextToken()); // 내구도가 0인 칸 개수 한계
		belt = new int[2 * N]; // 컨베이어 벨트 배열 (위아래 2N)
		robot = new boolean[N]; // 로봇 배열 (벨트 위: true, 벨트 아래: false)

		// 컨베이어 벨트 내구도 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < belt.length; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(simul(0));

		br.close();
	}

	private static int simul(int step) {
		while (check()) { // 내구도가 0인 칸의 개수가 K개 이상이면 종료
			// 벨트 오른쪽으로 한 칸 이동
			int temp = belt[belt.length - 1];
			for (int i = belt.length - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = temp;
			// System.out.println(Arrays.toString(belt));

			// 로봇도 같이 오른쪽으로 한 칸 이동
			for (int i = N - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = false; // 올리는 위치
			robot[N - 1] = false; // 내리는 위치
			// System.out.println(Arrays.toString(robot));

			// 로봇이 이동 가능할 경우
			for (int i = N - 1; i > 0; i--) {
				// 이동하려는 앞 칸이 비어있고 내구도가 0 이상일 때, 로봇 이동
				if (robot[i - 1] && !robot[i] && belt[i] > 0) {
					robot[i - 1] = false;
					robot[i] = true;
					belt[i]--;
				}
			}

			// 로봇 올리기
			if (belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}

			step++;
		}
		return step;

	}// simul close

	private static boolean check() {
		int cnt = 0;
		for (int i = 0; i < belt.length; i++) {
			if (belt[i] == 0)
				cnt++;
			if (cnt >= K)
				return false;
		}
		return true;
	}
}
