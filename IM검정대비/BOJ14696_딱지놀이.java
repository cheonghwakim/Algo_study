package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 14696 딱지놀이 https://www.acmicpc.net/problem/14696
public class BOJ14696_딱지놀이 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder string = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int a = 0, b = 0, c = 0, d = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			// a
			for (int j = 0; j < num; j++) {
				int type = Integer.parseInt(st.nextToken());
				if(type == 4)
					a++;
				else if (type == 3)
					b++;
				else if(type == 2)
					c++;
				else
					d++;
			}
			
			// b
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int type = Integer.parseInt(st.nextToken());
				if(type == 4) {
					a--;
				}
				else if (type == 3)
					b--;
				else if(type == 2)
					c--;
				else
					d--;
			}
			
			// 비교
			if(a > 0) 
				string.append("A\n");
			else if (a < 0) 
				string.append("B\n");
			else {
				if(b > 0)
					string.append("A\n");
				else if (b < 0)
					string.append("B\n");
				else {
					if(c > 0)
						string.append("A\n");
					else if (c < 0)
						string.append("B\n");
					else {
						if(d > 0)
							string.append("A\n");
						else if(d < 0)
							string.append("B\n");
						else
							string.append("D\n");
					}
				}
			}
		}
		System.out.println(string);
	}
}
