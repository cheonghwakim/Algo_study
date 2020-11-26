package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1213_펠린드롬만들기 {
	static int[] alphabet = new int[26];
	static char[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder string = new StringBuilder();
		char[] line = br.readLine().toCharArray();
		
		if(line.length == 1) {
			System.out.println(line[0]);
			return;
		}

		answer = new char[line.length];
		
		for (int i = 0; i < line.length; i++) {
			alphabet[line[i] - 65] += 1;
		}
		
//		int oddCnt = 0, oddIdx = 0;
//		for (int i = 0; i < line.length; i++) {
//			if(alphabet[i] % 2 == 1) {
//				oddCnt++;
//				oddIdx = i;
//			}
//		}
//		
//		if((line.length % 2 == 0 && oddCnt >= 1) || (line.length % 2 == 1 && oddCnt != 1)) {
//			System.out.println("I'm Sorry Hansoo");
//			return;		
//		}

		// while문 돌면서 짝수개 있으면 넣어줌
		int k = 0;
		boolean flag = false;
		for (int i = 0; i < 26; i++) {
			while(alphabet[i] != 0) {
				if(alphabet[i] == 1) {
					if(flag) {
						System.out.println("I'm Sorry Hansoo");
						return;
					}
					flag = true;
					answer[line.length / 2] = (char) (i + 65);
					break;
				}
				
				alphabet[i] -= 2;
				answer[line.length - k - 1] = answer[k++] = (char) (i + 65);
			}
		}

//		if(line.length % 2 == 1)
//			answer[line.length / 2] = (char) (oddIdx + 65);
		
		for (int i = 0; i < line.length; i++) {
			string.append(answer[i]);
		}
		System.out.println(string);
	}

}
