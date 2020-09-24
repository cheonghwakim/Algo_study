package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1244 스위치 켜고 끄기 https://www.acmicpc.net/problem/1244
public class BOJ10158_개미 {
	static int w, h, p, q, second;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		second = Integer.parseInt(br.readLine());
		int dir[] = {1, -1};
		int d = 0;
		// 가로와 세로를 나눠서 생각
		int x = second % (2*w); // 가로길이 2배만큼 시간이 지날때마다 x는 제자리 
		int y = second % (2*h); 
		for (int i = 0; i < x; i++) {
			p += dir[d%2];
			if(p == 0 || p == w)
				d++;
		}
		d = 0;
		for (int i = 0; i < y; i++) {
			q += dir[d%2];
			if(q == 0 || q == h)
				d++;
		}
		
		System.out.println(p + " " + q);
	}

}
