package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 2606 바이러스 https://www.acmicpc.net/problem/2606
public class BOJ2606_바이러스 {
	static int N, pairs, cnt;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pairs = Integer.parseInt(br.readLine());
		
		// 인접 리스트 초기화
		for (int i = 0; i <= N; i++) {
			adjlist.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < pairs; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adjlist.get(u).add(v);
			adjlist.get(v).add(u);
		}
		
		visited = new boolean[N + 1];
		visited[1] = true;
		dfs(1, cnt);
		System.out.println(cnt);
	}
	
	static void dfs(int node, int cnt2) {
		for(int i = 0; i < adjlist.get(node).size(); i++) {
			if(!visited[adjlist.get(node).get(i)]) {
				visited[adjlist.get(node).get(i)] = true;
				dfs(adjlist.get(node).get(i), cnt++);
			}
		}
		
		return;
	}
}
