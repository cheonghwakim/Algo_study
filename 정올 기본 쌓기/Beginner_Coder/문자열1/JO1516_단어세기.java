package jungol.Beginner_Coder.문자열1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JO1516_단어세기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String string = br.readLine();
			String[] stringarr = string.split(" ");
			
			if(stringarr[0].equals("END")) 
				break;
			
			Map<String, Integer> map = new HashMap<>();
			ArrayList<String> key = new ArrayList<>();
			
			for (int i = 0; i < stringarr.length; i++) {				
				if(!map.containsKey(stringarr[i])){
					key.add(stringarr[i]);
				}
				map.put(stringarr[i], map.getOrDefault(stringarr[i], 0) + 1);

			}
			
			Collections.sort(key);
			for (int i = 0; i < key.size(); i++) {
				sb.append(key.get(i)).append(" : ").append(map.get(key.get(i))).append("\n");
			}
			
		}
		System.out.println(sb);
	}

}
