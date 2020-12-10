package jungol.Beginner_Coder.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1692_곱셈_정답 {
	static int[][] num, result;
	static int[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int input1 = Integer.parseInt(br.readLine());
		int input2 = Integer.parseInt(br.readLine());

		sb.append(input1 * (input2 % 10)).append("\n");
		sb.append((input1 * (input2 % 100 / 10))).append("\n");
		sb.append((input1 * (input2 / 100))).append("\n");
		sb.append((input1 * input2));
		System.out.println(sb);
	}

}
