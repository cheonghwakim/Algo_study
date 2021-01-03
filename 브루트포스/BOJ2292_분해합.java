package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2292_분해합 {
	
	static int N;
	static int min = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
	
	public static int execute(int N) {
		for (int i = 0; i < 6; i++) { // map 초기화
			map.add(new ArrayList<Integer>());
		}
		
		int tmp = 2;
		int i = 1;
		while(true) { // 조건 만족할 때까지 반복
			
			for (int j = 0; j < 6; j++) { // 6방향
				map.get(j).add(tmp);  // j(6)방향으로 돌면서 숫자를 넣어줌 (1로부터 직선거리인 애들만)
				tmp += i; // 첫 번째는 +1씩 커지고 두 번째 줄 +2 ...
			}
			tmp += 1; // 6방향을 다 넣고 나면 +1 해줘야 1직선거리부터 넣을 수 있음
			
			if(tmp > N) // tmp가 입력받은 숫자보다 커지면 종료
				break;
			
			i += 1;
		}
	
		for (int d = 0; d < 6; d++) {
			for (int k = map.get(d).size() - 1; k > 0 ; k--) {
				// 만약 찾는 숫자가 map에 있다면 시작과 끝을 포함한 거리를 더해줌
				if(N == map.get(d).get(k))
					min = k + 2;
				
				// 찾는 숫자가 map에 없다면 N과 가장 가까운 수 찾기
				else if(min > k + 1 + Math.abs(map.get(d).get(k) - N)) {
					min = k + 1 + Math.abs(map.get(d).get(k) - N);
				}
			}
		}

		return min;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		System.out.println(execute(N)); // 3
	}

}

	/*
	1 7 13 19
	5 12 18 24

	map[6][Integer.parseInt] -> 1을 기준으로 직선거리가 가능한 숫자들을 저장
	처음 -> 1씩 커지게 넣, 2씩 커지게 넣

	탐색할때는 가장 가까운 수를 찾고 거기에 + 몇 하면 
	*/