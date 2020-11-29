package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1325_효율적인해킹_시간초과 {
	static ArrayList<Integer>[] node;
	static boolean[] visited;
	static int[] answer;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	 
	    answer = new int[n + 1];
	    node = (ArrayList<Integer>[]) new ArrayList[n + 1];
	    for (int i = 1; i <= n; i++) {
	        node[i] = new ArrayList<Integer>();
	    }
	 
	    for (int i = 0; i < m; i++) {
	    	st = new StringTokenizer(br.readLine());
	        int v1 = Integer.parseInt(st.nextToken());
	        int v2 = Integer.parseInt(st.nextToken());
	 
	        node[v1].add(v2);
	    }
	 
	    int max = 0;
	    for (int i = 1; i <= n; i++) {
	        visited = new boolean[n + 1]; // 매번 초기화해줘야 함!!
	        dfs(i);
	    }
	 

	    for (int i = 1; i <= n; i++) {
	        if (max < answer[i]) {
	            max = answer[i];
	        }
	    }
	 
	    for (int i = 1; i <= n; i++) {
	        if (max == answer[i]) {
	            sb.append(i).append(" ");
	        }
	    }
	 
	    System.out.println(sb);
	}
	 
	public static void dfs(int v) {
	    visited[v] = true;
	 
	    for (int next : node[v]) {
	        if (!visited[next]) {
	        	answer[next]++;
	            dfs(next);
	        }
	    }
	}
}
