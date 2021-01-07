package jungol.Beginner_Coder.재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// **
public class JO1459_숫자고르기 {
	static int N, nums[], last;
	
	// last는 마지막 점이 출발점과 같다면 사이클이 완성 됬으므로 리스트에 추가 
	static ArrayList<Integer> result = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		nums = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			visited[i] = true; // 무한 재귀에 빠지면 안 됨 -> 첫 시작점도 방문으로 체크
			last = i;
			dfs(i);
			visited[i] = false;
		}

		Collections.sort(result);
		sb.append(result.size()).append("\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int i) {
		
		if(!visited[nums[i]]) {
			visited[nums[i]] = true;
			dfs(nums[i]);
			visited[nums[i]] = false;
		}
		
		if(nums[i] == last) { // 마지막 점이 출발점과 같다면 사이클이 완성됐으므로 리스트에 추가
			result.add(last);
		}
	}
}