package jungol.Beginner_Coder.도형만들기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1291_구구단 {
	static int s, e;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
	
			if(s < 2 || e < 2 || s > 9 || e > 9) {
				System.out.println("INPUT ERROR!");
			} else
				break;
		}
		
		if(e > s) {
			for (int i = 1; i <= 9; i++) {
				for (int j = s; j <= e; j++) {
					if(i*j < 10)
						sb.append(j).append(" ").append("*").append(" ").append(i).append(" ").append("=").append("  ").append(i * j).append("   ");
					else
						sb.append(j).append(" ").append("*").append(" ").append(i).append(" ").append("=").append(" ").append(i * j).append("   ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
		} else {
			for (int i = 1; i <= 9; i++) {
				for (int j = s; j >= e; j--) {
					if(i*j < 10)
						sb.append(j).append(" ").append("*").append(" ").append(i).append(" ").append("=").append("  ").append(i * j).append("   ");
					else
						sb.append(j).append(" ").append("*").append(" ").append(i).append(" ").append("=").append(" ").append(i * j).append("   ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}
	
	}

}
