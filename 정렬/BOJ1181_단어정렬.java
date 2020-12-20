package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BOJ1181_단어정렬 {
	static int N;
	static ArrayList<String> list = new ArrayList<>();
	static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			if(map.containsKey(tmp)) continue;
			
			list.add(tmp);
			map.put(tmp, 1);
		}
		
		Collections.sort(list, new lengthOrder());
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}
	
	static class lengthOrder implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if(o1.length() != o2.length())
				return o1.length() - o2.length();
			else
				return o1.compareTo(o2);
		}
	}
}
