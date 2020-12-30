package jungol.Beginner_Coder.자료처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JO1102_스택 {
	static int N;
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String input = st.nextToken();
			if(input.equals("i")) {
				int in = Integer.parseInt(st.nextToken());
				stack.push(in);
			
			} else if(input.equals("c")) {
				sb.append(stack.size()).append("\n");
			
			}
			else if(input.equals("o")) {
				if(stack.isEmpty())
					sb.append("empty\n");
				else
					sb.append(stack.pop()).append("\n");
			}
		}
		System.out.println(sb);
	}
}
