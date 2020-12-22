package jungol.Beginner_Coder.문자열1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO2514_문자열찾기 {
	static String input;
	static int kcnt, icnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
		
		for (int i = 0; i < input.length() - 2; i++) {
			if(input.charAt(i) == 'K' && input.charAt(i + 1) == 'O' && input.charAt(i + 2) == 'I')
				kcnt++;
			
			if(input.charAt(i) == 'I' && input.charAt(i + 1) == 'O' && input.charAt(i + 2) == 'I')
				icnt++;
		}
		
		System.out.println(kcnt);
		System.out.println(icnt);
	}

}
