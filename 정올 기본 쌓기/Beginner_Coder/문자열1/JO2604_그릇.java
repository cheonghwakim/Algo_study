package jungol.Beginner_Coder.문자열1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class JO2604_그릇 {
	static String dish;
	static int height;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dish = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < dish.length(); i++) {
			stack.push(dish.charAt(i));
		}
		
		char cur = stack.pop();
		height += 10;
		while(!stack.isEmpty()) {
			
			if(cur != stack.peek()) 
				height += 10;
			else if(cur == stack.peek())
				height += 5;
			
			if(stack.isEmpty()) break;
			
			cur = stack.pop();
		}
		
		System.out.println(height);
	}

}
