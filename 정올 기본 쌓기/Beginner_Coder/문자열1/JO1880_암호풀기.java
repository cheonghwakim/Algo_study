package jungol.Beginner_Coder.문자열1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class JO1880_암호풀기 {
	static char[] key = new char[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String keyString = br.readLine();
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < keyString.length(); i++) {
			map.put((char) (i + 97), keyString.charAt(i));
			map.put((char) (i + 65), (char) (keyString.charAt(i) - 32));
		}
		
		String message = br.readLine();
		for (int i = 0; i < message.length(); i++) {
			if(!map.containsKey(message.charAt(i))) 
				sb.append(" ");
			else
				sb.append(map.get(message.charAt(i)));
		}
		
		System.out.println(sb);
	}
}
