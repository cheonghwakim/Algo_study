package jungol.Beginner_Coder.자료처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO1814_삽입정렬횟수세기 {
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int move = 0;
		for (int i = 1; i < N; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if(list.get(j) > list.get(i))
					move++;
				else {
					int tmp = list.remove(i);
					list.add(j + 1, tmp);
					break;
				}
				if(j == 0) {
					int tmp = list.remove(i);
					list.add(0, tmp);
				}
			}
		}
		System.out.println(move);
	}
}