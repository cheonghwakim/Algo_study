package jungol.Beginner_Coder.문자열1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class JO3699_변장 {
	static int T, N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
		
			Map<String, Integer> map = new HashMap<>();
			ArrayList<String> key = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				
				if(!map.containsKey(type))
					key.add(type);
				map.put(type, map.getOrDefault(type, 0) + 1);
			}
			
			int answer = 1;
			
			for (int i = 0; i < key.size(); i++) {
				answer *= (map.get(key.get(i)) + 1);
			}
			
			sb.append(answer - 1).append("\n");
		}
		System.out.println(sb);
	}
}
