package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2527 직사각형 https://www.acmicpc.net/problem/2527
public class BOJ2527_직사각형 {
	static int x, y, p, q;
	static int x2, y2, p2, q2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			p2 = Integer.parseInt(st.nextToken());
			q2 = Integer.parseInt(st.nextToken());
			

			if((x == p2 && y == q2) || (x == p2 && y2 == q) || (x2 == p && y == q2) || (x2 == p && y2 == q)) {
				System.out.println("c");
			}
			else if(x == p2 || x2 == p || y2 == q || y == q2) {
				System.out.println("b");
			}
			else if(x > p2 || x2 > p || y > q2 || y2 > q)
				System.out.println("d");
			else
				System.out.println("a");
		}
	}

}

//			else if(x < x2 && p < p2) {
//				if((y < y2 && q < q2) || (y > y2 && q > q2)) {
//					System.out.println("a");			}
//			}
//			else if(x > x2 && p > p2) {
//				if((y < y2 && q < q2) || (y > y2 && q > q2)) {
//					System.out.println("a");
//				}
//			}