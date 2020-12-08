package jungol.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1341_구구단2 {
	static int s, e;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
	
		if(e > s) {
			for (int i = s; i <= e; i++) {
				for (int j = 1; j <= 9; j++) {
					if(i*j < 10)
						sb.append(i).append(" ").append("*").append(" ").append(j).append(" =  ").append(i * j).append("   ");
					else
						sb.append(i).append(" ").append("*").append(" ").append(j).append(" = ").append(i * j).append("   ");
					
					if(j % 3 == 0) sb.append("\n");
				}
				sb.append("\n");
			}
		} else {
			
			for (int i = s; i >= e; i--) {
				for (int j = 1; j <= 9; j++) {
					if(i*j < 10)
						sb.append(i).append(" ").append("*").append(" ").append(j).append(" =  ").append(i * j).append("   ");
					else
						sb.append(i).append(" ").append("*").append(" ").append(j).append(" = ").append(i * j).append("   ");
					
					if(j % 3 == 0) sb.append("\n");
				}
				sb.append("\n");
			}
			
		}
	
		
		System.out.println(sb);
	}

}
