package dongbinbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그리디_숫자카드게임 {
	static int N, M, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		int tmp;
		for (int i = 0; i < N; i++) {
			tmp = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tmp = Math.min(tmp, Integer.parseInt(st.nextToken()));
			}
			max = Math.max(max, tmp);
		}
		
		System.out.println(max);
	}

}
