package jungol.Beginner_Coder.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1761_숫자야구 {
	static int N, totalCnt, question[][], result[][], permresult[];
	static boolean[] isSelected = new boolean[9];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		question = new int[N][3];
		result = new int[N][2];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			for (int j = 2; j >= 0; j--) {
				question[i][j] = num % 10;
				num /= 10;
			}
			
			result[i][0] = Integer.parseInt(st.nextToken());
			result[i][1] = Integer.parseInt(st.nextToken());
		}
		
		permresult = new int[3];
		perm(0);
		
		System.out.println(totalCnt);
	}

	private static void perm(int cnt) {
		if(cnt == 3) {
			// 여기서 결과랑 비교
			boolean[] isAnswer = new boolean[N];
			// 해당 위치 해당 숫자 같으면 스트라이크++
			// 위치는 다른데 숫자 같으면 볼++
			int strike, ball;
			for (int i = 0; i < N; i++) {
				strike = 0;
				ball = 0;
				for (int k = 0; k < 3; k++) {
					for (int j = 0; j < 3; j++) {
						if(question[i][k] == permresult[j]) {
							if(k == j)
								strike++;
							else
								ball++;
						}
					}
				}					
				if(result[i][0] == strike && result[i][1] == ball)
					isAnswer[i] = true;
			}
			
			for (int i = 0; i < isAnswer.length; i++) {
				if(!isAnswer[i])
					return;
			}
			totalCnt++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			permresult[cnt] = i + 1;
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}
}