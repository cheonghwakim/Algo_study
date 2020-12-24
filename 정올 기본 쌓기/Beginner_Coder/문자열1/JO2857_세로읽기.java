package jungol.Beginner_Coder.문자열1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO2857_세로읽기 {
	static char[][] character = new char[15][15];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 5; i++) {
			String string = br.readLine();
			
			for (int j = 0; j < string.length(); j++) {
				character[i][j] = string.charAt(j);
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(character[j][i] != '\0')
					sb.append(character[j][i]);
			}
		}
		System.out.println(sb);
	}
}
