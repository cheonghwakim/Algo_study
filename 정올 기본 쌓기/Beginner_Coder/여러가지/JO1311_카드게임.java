package jungol.Beginner_Coder.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class JO1311_카드게임 {
	static int jumsu;
	static ArrayList<Card> cards = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			
			String color = st.nextToken();
			int number = Integer.parseInt(st.nextToken());
		
			cards.add(new Card(color, number));
		}
		Collections.sort(cards);
		
		// 1. 숫자 같음
		// 2) 4장 숫자 같을 때, 3) 3장의 숫자 같고 2장 숫자 같을 때 
		// 6) 3장 숫자 같을 때, 7) 2장 같고, 2장 같을 때 , 8) 2장 숫자 같을 때
		boolean flag = true;
		Map<Integer, Integer> map = new HashMap<>();
//		Map<String, Integer> Cmap = new HashMap<>();
		for (int i = 0; i < 5; i++) {
			map.put(cards.get(i).number, map.getOrDefault(cards.get(i).number, 0) + 1);
//			Cmap.put(cards.get(i).color, map.getOrDefault(cards.get(i).color, 0) + 1);
		}
		
		ArrayList<Obj> cnt = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			if(map.containsKey(i)) {
				cnt.add(new Obj(i, map.get(i)));
			}
		}
		// cnt[1] 내림차순으로 정렬
		Collections.sort(cnt);

		
		if(cnt.get(0).value == 4) { // 2)
			jumsu = cnt.get(0).idx + 800;
			System.out.println(jumsu);
			return;
		
		} else if(cnt.get(0).value == 3) {
			if(cnt.get(1).value == 2) { // 3)
				jumsu = cnt.get(0).idx * 10 + cnt.get(1).idx + 700;
				System.out.println(jumsu);
				return;
			} else { // 6)
				jumsu = cnt.get(0).idx + 400;
				System.out.println(jumsu);
				return;
			}
		} else if(cnt.get(0).value == 2) {
			if(cnt.get(1).value == 2) { // 7)
				if(cnt.get(0).idx < cnt.get(1).idx) {
					jumsu = cnt.get(1).idx * 10 + cnt.get(0).idx + 300;
				} else {
					jumsu = cnt.get(0).idx * 10 + cnt.get(1).idx + 300;
				}
				System.out.println(jumsu);
				return;
			} else { // 8)
				jumsu = cnt.get(0).idx + 200;
				System.out.println(jumsu);
				return;
			}
		}
		
		
		// 2. 숫자 연속적
		// 1) 같은 색, 5) 가장 높은 숫자에 + 500
		flag = true;
		int startN = cards.get(0).number;
		for (int i = 1; i < 5; i++) {
			if(--startN != cards.get(i).number) {
				flag = false;
				break;
			}
		}
		
		String startC = cards.get(0).color;
		if(flag) {
			for (int i = 1; i < 5; i++) {
				// 5) 숫자 연속적 + 색 다름
				if(!startC.equals(cards.get(i).color)) {
					jumsu = cards.get(0).number + 500;
					System.out.println(jumsu);
					return;
				}
			}
			// 1) 숫자 연속적 + 색 같음
			if(flag) {
				jumsu = cards.get(0).number + 900;
				System.out.println(jumsu);
				return;
			}
		}
		
		// 3. 색이 모두 같을 때
		// 4) 색 모두 같을 때
		flag = true;
		startC = cards.get(0).color;
		for (int i = 0; i < 5; i++) {
			if(!startC.equals(cards.get(i).color))
				flag = false;
		}
		
		if(flag) {
			jumsu = cards.get(0).number + 600;
			System.out.println(jumsu);
			return;
		}
		
		// 4. 아무 것도 아닐때
		// 9) 아무것도 아닐 때
		jumsu = cards.get(0).number + 100;
		System.out.println(jumsu);
	}
	
	static class Card implements Comparable<Card> {
		String color;
		int number;
		
		Card (String color, int number) {
			this.number = number;
			this.color = color;
		}

		@Override
		public int compareTo(Card o) {
			return o.number - this.number;
		}
	}
	
	static class Obj implements Comparable<Obj> {
		int idx;
		int value;
		
		Obj(int idx, int value){
			this.idx = idx;
			this.value = value;
		}

		@Override
		public int compareTo(Obj o) {
			return o.value - this.value;
		}
	}
}
