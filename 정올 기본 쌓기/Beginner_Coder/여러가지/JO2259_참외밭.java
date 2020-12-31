package jungol.Beginner_Coder.여러가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2259_참외밭 {
	static int quantity, length[], rowMax, rMidx, colMax, cMidx;
	static boolean[] isSelected = new boolean[6];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		quantity = Integer.parseInt(br.readLine());
		
		length = new int[6];
		StringTokenizer st = null;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			if(dir == 1 || dir == 2) {
				if(colMax < len) {
					colMax = len;
					cMidx = i;
				}
			}
			else if(dir == 3 || dir == 4) {
				if(rowMax < len) {
					rowMax = len;
					rMidx = i;
				}
			}
			
			length[i] = len;
		}
		
		// rM, cM 좌우 빼고
		if(rMidx - 1 < 0 || cMidx - 1 < 0) isSelected[5] = true;
		if(rMidx + 1 >= 6 || cMidx + 1 >= 6) isSelected[0] = true;
		if(rMidx + 1 < 6)
			isSelected[rMidx + 1] = true;
		if(rMidx - 1 >= 0)
			isSelected[rMidx - 1] = true;
		if(cMidx + 1 < 6)
			isSelected[cMidx + 1] = true;
		if(cMidx - 1 >= 0)
			isSelected[cMidx - 1] = true;
		
		int sArea = 1;
		for (int i = 0; i < 6; i++) {
			if(!isSelected[i])
				sArea *= length[i];
		}
		
		int tArea = rowMax * colMax - sArea; 
		int result = tArea * quantity;
		
		System.out.println(result);
	}
}
