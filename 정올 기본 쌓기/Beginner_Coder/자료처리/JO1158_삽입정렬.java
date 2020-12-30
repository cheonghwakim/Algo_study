package jungol.Beginner_Coder.자료처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO1158_삽입정렬 {
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 1; i < N; i++) {
			
			int j = i;
			for (; j >= 0; j--) {
				if(list.get(j) < list.get(i)) // 정렬이 잘 된 상태라면  arr[j] < arr[i] 
					break;
			}
			
			int tmp = list.remove(i);
			list.add(j + 1, tmp);
			
			for (int k = 0; k < N; k++) {
				sb.append(list.get(k)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}