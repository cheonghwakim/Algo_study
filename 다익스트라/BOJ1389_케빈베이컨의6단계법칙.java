package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 참고: 굳이 다익스트라를 쓰지 않아도 되는 이유 https://jaejin89.tistory.com/107
public class BOJ1389_케빈베이컨의6단계법칙 {
	static int N, M, map[][];
	static int[] answer, distance[];
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		answer = new int[N + 1];
		distance = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		map = new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
		
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
			
		int start;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j)
					distance[i][j] = 0;
			}
		}
		
		for (start = 1; start <= N; start++) {		
			int end = N;
			visited = new boolean[N + 1];
			pq.clear();
			pq.add(new Vertex(start, distance[start][start]));
			Vertex cur = null;
			
			while(!pq.isEmpty()) {
				
				// 방문하지 않은 정점 중 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택
				cur = pq.poll();
				if(visited[cur.no]) continue; // pq에 남아있던 totalDistance의 최소비용보다 큰 상태
				
				visited[cur.no] = true;
				if(cur.no == end) break;
				
				for (int i = 1; i <= N; i++) {
					if(!visited[i] && map[cur.no][i] != 0 && distance[start][i] > cur.totalDistance + map[cur.no][i]) {
						distance[start][i] = cur.totalDistance + map[cur.no][i];
						pq.add(new Vertex(i, distance[start][i]));
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				distance[i][start] = distance[start][i];
			}
		}
		
		int total;
		for (int i = 1; i <= N; i++) {
			total = 0;
			for (int j = 1; j <= N; j++) {
				total += distance[i][j];
			}
			answer[i] = total;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			if(min > answer[i]) min = answer[i];
		}
		
		for (int i = 1; i <= N; i++) {
			if(min == answer[i]) {
				System.out.println(i);
				break;
			}
		}

	}
	
	static class Vertex implements Comparable<Vertex>{
		int no;
		int totalDistance;
		
		Vertex(int no, int totalDistance) {
			this.no = no;
			this.totalDistance = totalDistance;
		}
		
		@Override
		public int compareTo(Vertex o) {
			return this.totalDistance - o.totalDistance; // totalDistance가 작은 비용이 우선적으로 처리
		}
		
	}

}
