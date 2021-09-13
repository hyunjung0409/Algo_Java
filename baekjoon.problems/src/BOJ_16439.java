import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16439 {
	
	static int N, M, chicken[][];
	static int max = 0;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chicken = new int [N][M];
		isSelected = new boolean[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				chicken[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//System.out.println(Arrays.deepToString(chicken));
		System.out.println(chicken.length+" "+ chicken[0].length);
		//makeSubset(0);
		
	}

	private static void makeSubset(int cnt) { //cnt: 부분집합을 처리하기 위해 고려된 원소의 갯수

		//부분집합 완성
/*		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				if(isSelected[i]) //true이면
					sum += chicken[i];
			}
		}
		
		//현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		makeSubset(cnt+1);
		
		//현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false;
		makeSubset(cnt+1);*/
	}

}
