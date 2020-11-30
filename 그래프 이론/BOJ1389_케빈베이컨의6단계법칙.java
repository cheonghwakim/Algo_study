package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N,M;
	public static int min=987654321;
	public static int ans;
	public static int[][] map;
	public static boolean[] chk;
	public static int[] total;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		total=new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			map[n1][n2]=1;
			map[n2][n1]=1;
		}
		for(int i=1; i<=N; i++) {
			
			for(int j=1; j<=N; j++) {
				chk=new boolean[N+1];
				if(i==j) continue;
				chk[i]=true;
				total[i]+=bfs(i,j);
			}
		}
		for(int i=1; i<=N; i++) {
			if(min>total[i]) {
				min=total[i];
				ans=i;
			}
		}
		System.out.println(ans);
		
	}
	private static int bfs(int from, int to) {
		Queue<Integer> q =new LinkedList<Integer>();
		for(int j=1; j<=N; j++) {
			if(map[from][j]==1) {
				chk[j]=true;
				q.offer(j);
			}
		}
		int cnt=1;
		while(!q.isEmpty()) {
			int qSize=q.size();
			while(qSize-->0) {
				int num=q.poll();
				if(num==to) {
					return cnt;
				}
				for(int j=1; j<=N; j++) {
					if(chk[j]==true || map[num][j]==0) continue;
					chk[j]=true;
					q.offer(j);
				}
			}
			cnt++;
		}
		return 0;
	}

}