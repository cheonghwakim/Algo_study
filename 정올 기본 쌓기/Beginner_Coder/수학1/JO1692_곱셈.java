package jungol.Beginner_Coder.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1692_곱셈 {
	static int[][] num, result;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		num = new int[2][3];
		String tmp = br.readLine();
		String tmp2 = br.readLine();
		for (int j = 0; j < 3; j++) {
			num[0][j] = Integer.parseInt(tmp.split("")[j]);
			num[1][j] = Integer.parseInt(tmp2.split("")[j]);
		}
		
		result = new int[3][4];
		answer = new int[7];
		int carry = 0;
		for (int i = 2; i >= 0; i--) {
			carry = 0;
			for (int j = 2; j >= 0; j--) {
				int mul = num[0][j] * num[1][i];
				mul += carry;
				carry = mul / 10;
				mul %= 10;
				result[2 - i][j + 1] = mul;
				if(j == 0) {
					result[2 - i][0] = carry;
				}
			}
		}

		int ans = 0;
		carry = 0;
		answer[6] = result[0][3];		
		ans = result[0][2] + result[1][3];
		ans += carry;	
		
		if(ans > 0) {
			carry = ans / 10;
			ans %= 10;
		} else 
			carry = 0;
		answer[5] = ans;

		ans = result[0][1] + result[1][2] + result[2][3];
		ans += carry;
		if(ans > 0){
			carry = ans / 10;
			ans %= 10;
		} else
			carry = 0;
		answer[4] = ans;

		ans = result[0][0] + result[1][1] + result[2][2];
		ans += carry;
		if(ans > 0) {
			carry = ans / 10;
			ans %= 10;
		} else
			carry = 0;
		answer[3] = ans;
		
		ans = result[1][0] + result[2][1];
		ans += carry;
		if(ans > 0) {
			carry = ans / 10;
			ans %= 10;
		} else
			carry = 0;
		answer[2] = ans;
		
		ans = result[2][0] + carry;
		if(ans > 0) {
			carry = ans / 10;
			ans %= 10;
		} else
			carry = 0;
		answer[1] = ans;

		answer[0] = carry;
		String sum = "";
		for (int i = 0; i < 3; i++) {
			sum = "";
			for (int j = 0; j < 4; j++) {
				sum += result[i][j];
			}
			int d = Integer.parseInt(sum);
			sb.append(d).append("\n");
		}
		
		sum = "";
		for (int i = 0; i < 7; i++) {
			sum += answer[i];
		}
		int d = Integer.parseInt(sum);
		sb.append(d).append("\n");
		
		System.out.println(sb);
		
	}

}
