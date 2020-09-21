package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 백준 2309 일곱 난쟁이 https://www.acmicpc.net/problem/2309
public class BOJ2309_일곱난쟁이 {
	static ArrayList<Integer> arr = new ArrayList<>();
	static ArrayList<Integer> result = new ArrayList<>();
	static int num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		comb(9, 7, 0);
		
	}
	
	static void comb(int n, int r, int idx) {
		if(r == 0) {
			for (int i = 0; i < 7; i++) {
				num += result.get(i);
			}
			if(num == 100) {
				Collections.sort(result);
				for (int i = 0; i < 7; i++) {
					System.out.println(result.get(i));
				}
			}
			num = 0;
			return;
		}
		
		for(int i = idx; i < n; i++) {
			result.add(arr.get(i));
			comb(n, r - 1, i + 1);
			result.remove(result.size() - 1);
		}
	}

}
