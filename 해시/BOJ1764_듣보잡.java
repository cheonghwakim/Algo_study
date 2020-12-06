package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1764_듣보잡 {
	static int N, M;
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			map.put(input, map.getOrDefault(input, 0) + 1);
		}
		
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			map.put(input, map.getOrDefault(input, 0) + 1);
		}
		
		for (String key : map.keySet()) {
			if(map.get(key) == 2)
				list.add(key);
		}
		
		sb.append(list.size()).append("\n");
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
		
	}

}
