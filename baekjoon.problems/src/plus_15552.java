//빠른 A+B (1. StringBuilder  2. BufferedWriter)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class plus_15552 {

	public static void main(String[] args) throws IOException {
		
		//1. StringBuilder
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
		}
		br.close();
		
		System.out.println(sb);*/
		
		// 2. BufferedWriter
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			//정수 입력과 동시에 분리
			st = new StringTokenizer(br.readLine(), " "); 
			//분리되어있는 문자(토큰) 반환 -> int형으로 변환
			bw.write((Integer.parseInt(st.nextToken()))+(Integer.parseInt(st.nextToken()))+"\n");
		}
		br.close();
		bw.flush(); //buffer를 비움
		bw.close(); //buffer를 닫음
		
	}

}
