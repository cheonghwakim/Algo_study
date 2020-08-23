package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// boj 1302 베스트 셀러 https://www.acmicpc.net/problem/1302
public class BestSeller {
	static int N;
	static String book;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> keySetList = new ArrayList<String>();
		
		for (int i = 0; i < N; i++) {
			book = br.readLine();
			map.put(book, map.getOrDefault(book, 0) + 1);
		}
		
		int max = 0;
		String maxkey = "";
        for(String key : map.keySet()){
            if(max <= map.get(key)) {
            	max = map.get(key);
            }
        }
        
        for (String key : map.keySet()) {
			if(max == map.get(key)) { // max값 찾아서 ArrayList에 넣어줌
				keySetList.add(key);
			}
		}
        
        Collections.sort(keySetList); // 사전순 정렬
        
        maxkey = keySetList.get(0);
        System.out.println(maxkey);
        
	}

}
