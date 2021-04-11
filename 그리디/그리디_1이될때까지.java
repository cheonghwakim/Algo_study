package dongbinbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그리디_1이될때까지 {
	static int N, K, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		while(N > 1) {
			if(N % K == 0) N /= K;
			else N -= 1;
			cnt++;
		}
		System.out.println(cnt);
	}

}
