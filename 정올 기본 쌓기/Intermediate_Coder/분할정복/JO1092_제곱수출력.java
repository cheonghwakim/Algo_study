package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1092_제곱수출력 {
	static int x, y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		if(x == 0 && y == 0) {
			System.out.println(1);
			return;
		}

		System.out.println(square(x, y));
	}

	private static long square(int x, int y) {
		if(y == 0)
			return 1;
		
		long answer = square(x, y / 2) % 20091024;
		
		if(y % 2 != 0)
			return (answer % 20091024 * answer % 20091024 * x) % 20091024;
		return (answer % 20091024 * answer % 20091024) % 20091024;
	}
}