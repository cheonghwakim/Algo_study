package jungol.Beginner_Coder.자료처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1697_큐 {
	static int N;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String input = st.nextToken();
			if(input.equals("i")) {
				int in = Integer.parseInt(st.nextToken());
				q.add(in);
				
			} else if(input.equals("o")) {
				if(q.isEmpty())
					sb.append("empty\n");
				else
					sb.append(q.poll()).append("\n");
				
			} else if(input.equals("c"))
				sb.append(q.size()).append("\n");
		}
		System.out.println(sb);
	}
}
