package jungol.Beginner_Coder.수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class JO2809_약수 {
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		int sq = (int) Math.sqrt(n);
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= sq; i++) {
			
			if(n % i == 0) {
				list.add(i); // 작은 수 저장
				
				if(n / i != i) {
					list.add(n / i); // 큰 수 저장
				}
			}
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}

}
