package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW3234_준환이의양팔저울 {
	
	static int T;
	static int N;
	
	static int totalWeight;
	static int[] weights;
	static boolean[] isSelected;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringBuilder string = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			weights = new int[N];
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
				totalWeight += weights[i];
			}
			
			ans = 0;
			Perm(0, 0, 0, totalWeight);
			
			string.append("#" + t + " " + ans + "\n");
		}
		System.out.println(string);
	}
	
	// left: 왼쪽 추들의 합, right: 오른쪽 추들의 합
	static void Perm(int cnt, int left, int right, int remain) {		
		
		if(cnt == N) {
			ans++;
			return;
		}
		
		// 현재 상태에서 남아있는 추를 모두 오른쪽에 놔도 left 이하
		if(left >= remain + right) {
			int pow = 1, fac = 1;
			// 남은 개수까지 pow와 fac 구함 (2^n*n!)
			for (int i = 1; i <= N - cnt; i++) {
				pow *= 2;
				fac *= i;
			}				
			ans += pow * fac;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				
				// 현재 무게
				int curWeight = weights[i];
				
				Perm(cnt + 1, left + curWeight, right, remain - curWeight);
				
				// 오른쪽 무게가 왼쪽 무게보다 무거우면 안 됨
				if(right + curWeight <= left) {
					Perm(cnt + 1, left, right + curWeight, remain - curWeight);
				}
				isSelected[i] = false;
			}
		}
	}

}
