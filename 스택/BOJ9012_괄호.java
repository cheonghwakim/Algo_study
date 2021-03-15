package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012_괄호 {
	static int T;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			
			Stack<Character> st = new Stack<>();
			boolean isGwalho = true;
			for (int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == '(') {
					st.add('(');
				} else if(line.charAt(i) == ')' && st.size() > 0 && st.peek() == '(')
					st.pop();
				else {
					isGwalho = false;
					break;
				}
			}
			
			if(st.size() != 0)
				isGwalho = false;
			
			if(isGwalho)
				sb.append("YES\n");
			else
				sb.append("NO\n");
				
		}
		System.out.println(sb);
	}
}
