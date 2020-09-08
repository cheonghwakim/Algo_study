package com.ssafy.bj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
	
public class BJ1697_HideAndSeek {
	
	static int size = 100001;
    static int[] point = new int[size];
    static boolean[] check = new boolean[size];
    
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt(); //수빈이의 위치
        int target = sc.nextInt(); //동생의 위치
        Arrays.fill(point, -1);
        bfs(start, target);
        
        System.out.println(point[target]);
         
	}
    public static void bfs(int S, int T) {
        int nextS = S;
        int[] status = new int[3];
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(nextS);
        point[nextS] = 0;
 
        while (!q.isEmpty() && nextS != T) {
 
            nextS = q.poll();
            //다음에 이동할 좌표들
            status[0] = nextS - 1;     //뒤로 한칸
            status[1] = nextS + 1;    //앞으로 한칸
            status[2] = nextS * 2;    //순간이동
 
            for (int i = 0; i < 3; i++) {
                //배열을 벗어나지 않았는지 확인
                if (status[i] >= 0 && status[i] <= 100000) {
                    //이전에 방문했는지 확인
                    if (point[status[i]] == -1) {
                        //처음 간 곳이라면 큐에 넣고 상태를 전 위치값 +1 을 해준다. ( 몇 초인지 세기 위함)
                        q.add(status[i]);
                        point[status[i]] = point[nextS] + 1;
                    }
                }
            }
        }
    }
}
