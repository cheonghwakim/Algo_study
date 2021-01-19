package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ5430_AC {
	static int T, n;
	static boolean error;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int tc = 0; tc < T; tc++) {
			error = false;
//			Deque<String> dq = new LinkedList<>();
			Deque<String> dq = new ArrayDeque<>();
			
			String input = br.readLine();
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), "[,]");
			while(st.hasMoreTokens()) {
				dq.add(st.nextToken());
			}
			
			boolean idx = false;
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == 'R') {
					idx = !idx;
				} else {
					if(dq.size() == 0) {
						error = true;
						break;
					}
					else {
						if(!idx)
							dq.removeFirst();
						else
							dq.removeLast();
					}
				}
			}
			
			if(error)
				sb.append("error\n");
			else {
				sb.append("[");
				while(!dq.isEmpty()) {
					
					if(!idx)
						sb.append(dq.removeFirst());
					else
						sb.append(dq.removeLast());
					
					if(dq.size() > 0)
						sb.append(",");
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}