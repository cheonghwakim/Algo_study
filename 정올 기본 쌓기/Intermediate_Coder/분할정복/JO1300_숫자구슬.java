package jungol.Intermediate_Coder.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대값의 최소값: Binary Search !!
public class JO1300_숫자구슬 {
	static int M, N, arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 구슬 개수
		M = Integer.parseInt(st.nextToken()); // 그룹 수
		
		int left = Integer.MAX_VALUE, right = 0;
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right += arr[i];
			left = Math.min(left, arr[i]);
		}
		
		// 최소: 구슬 중 가장 작은 무게, 최대: 구슬들의 합
		while(left <= right) {
			int mid = (left + right) / 2; // 최대값이 mid라고 가정
			int cnt = 1;
			
			// 각 원소를 더하여 그룹 개수 추정
			for (int i = 0, sum = 0; i < N; ++i) {
				
				sum += arr[i];
				//새로운 그룹으로 처리할 때 그룹 개수 1개 추가
				if(sum > mid) {
					++cnt;
					sum = arr[i];
				}
			}
			
			if(cnt > M) {
				left = mid + 1;
				
			} else {
				right = mid - 1;
			}
		}

		printAns(left);
	}

	private static void printAns(int answer) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(answer).append("\n");
		
		int sum = 0, cnt = 0;
		for (int i = 0; i < N; ++i) {
			sum += arr[i];
			
			if(sum > answer) {
				sum = arr[i];
				M--;
				sb.append(cnt).append(" ");
				cnt = 0;
			}
			cnt++;		
			// M개의 그룹을 만들기 위해 최소한의 구슬은 남겨두기
			// 나머지 그룹에 적어도 구슬 한 개는 배치해야 함
			if(N - i == M) break;
		}
		
		// 위에서 구한 구슬 개수를 현재 그룹까지만 출력
		// 나머지 남은 그룹에는 구슬 1개씩 배치
		while(M-- > 0) {
			sb.append(cnt).append(" ");
			cnt = 1;
		}
		
		System.out.println(sb);
	}
}