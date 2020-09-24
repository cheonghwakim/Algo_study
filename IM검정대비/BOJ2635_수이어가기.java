package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 백준 2635 수 이어가기 https://www.acmicpc.net/problem/2635
public class BOJ2635_수이어가기 {
	static int num, max;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Integer> result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		for (int i = 0; i <= num; i++) {
			list.add(num);
			list.add(i);
			f();
			list.clear();
		}
		
		System.out.println(max);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
		
	}
	
	static void f() {
		int tmp = 2;
		while(true) {
			if(list.get(tmp - 2) - list.get(tmp - 1) < 0) {
				if(max < list.size()) {
					max = list.size();
				
					result = new ArrayList<Integer>();
					result.addAll(list);
				}
				break;
			}
			
			list.add(list.get(tmp - 2) - list.get(tmp - 1));
			tmp++;
		}
	}
}

// f(n) = f(n-2) - f(n-1)