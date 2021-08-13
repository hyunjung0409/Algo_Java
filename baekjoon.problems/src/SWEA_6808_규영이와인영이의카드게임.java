import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임 {
	
	static int N=9, K_cards[], I_cards[];
	static boolean isSelected[];
	static int permutation[], count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			boolean[] card = new boolean[19]; //card 1~18
			K_cards = new int[N]; //배열 초기화 필수!! 안해주면 NullPointer exception 발생
			I_cards = new int[N]; //배열 초기화 필수!! 안해주면 NullPointer exception 발생
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				K_cards[i] = Integer.parseInt(st.nextToken());//규영이 카드 배열에 저장
				card[K_cards[i]] = true; //규영이 카드 true로 체크
			}
			
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if(!card[i]) { //false인 숫자를
					I_cards[idx++] = i; //인영이 카드 배열에 저장
				}
			}
			
			permutation = new int[N]; //함수 호출 전에 초기화
			isSelected = new boolean[N]; //함수 호출 전에 초기화
			
			count = 0; //함수 호출 전에 초기화 

			makePermutation(0);
			
			sb.append("#"+tc+" "+count+" "+(362880-count)+"\n"); //9! = 362880
		}//T만큼 반복
		
		System.out.println(sb.toString());
		
	}//main close

	private static void makePermutation(int cnt) {
		
		if(cnt==N) { //순열 완성됐을 때,
			int K_score=0, I_score=0;
			for (int i = 0; i < N; i++) { //규영, 인영 카드 비교
				if(K_cards[i] > permutation[i])
					K_score += K_cards[i] + permutation[i];	// +=로 값 누적시키기					
				else if(K_cards[i] < permutation[i])
					I_score += K_cards[i] + permutation[i];	// +=로 값 누적시키기				
			}
			if(K_score> I_score)
				count++;
		}
		
		else {
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) continue;
				
				//이미 뽑힌 수가 아니라면 자리에 해당 숫자를 넣어준다
				permutation[cnt] = I_cards[i]; //cnt!!!로 해주기!!!! 자리가 계속 바뀌는 것!!!!! 
				isSelected[i] = true;
				
				makePermutation(cnt+1); //다음 자리로 이동
				isSelected[i] = false;
			}
		}
	}//makePermutation close

}//class close
