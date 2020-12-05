package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935_문자열폭발 {
	static String string, bomb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		string = br.readLine();
		bomb = br.readLine();
		
		while(string.contains(bomb)) {
			String result = "";
			String[] tmp = string.split(bomb);
			for (int i = 0; i < tmp.length; i++) {
				result += tmp[i];
			}
			string = result;
		}
		
		if(string.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(string);
	}

}
