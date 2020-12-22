package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1259_펠린드롬수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		loop: while(true) {
			String input = br.readLine();
			
			if(input.equals("0")) break;
			
			for (int i = 0; i < input.length() / 2; i++) {
				if(input.charAt(i) != input.charAt(input.length() - 1 - i)) {
					sb.append("no").append("\n");
					continue loop;
				}
			}
			sb.append("yes").append("\n");
		}
		
		System.out.println(sb);
	}
}
