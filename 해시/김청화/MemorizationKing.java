package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// boj 2776 암기왕 https://www.acmicpc.net/problem/2776
public class MemorizationKing {
	static int T;
	static int note1_num, note2_num;
	static boolean isIn = false;
	static StringBuilder string = new StringBuilder();
	
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			note1_num = Integer.parseInt(br.readLine());
		
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < note1_num; i++) {
				map.put(st.nextToken(), 1);
			}
			
			note2_num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < note2_num; i++) {
				if (map.containsKey(st.nextToken())) {
					string.append("1\n");
				} else 
					string.append("0\n");
			}
		}
		System.out.println(string);
	}
	
}
