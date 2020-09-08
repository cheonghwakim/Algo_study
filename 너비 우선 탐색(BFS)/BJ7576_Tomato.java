package com.ssafy.bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BFS
public class BJ7576_Tomato {
	 
    static int N;
    static int M;
    static int[][] box;
    static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} }; // 동서남북
 
    static class Dot {
        int x;
        int y;
        int day;
 
        public Dot(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
 
        box = new int[M][N];
 
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                box[i][j] = sc.nextInt();
            }
        }
 
        bfs();
    }
 
    static void bfs() {
        Queue<Dot> q = new LinkedList<Dot>();
        int day = 0;
 
        // 토마토가 있는 좌표 찾아서 Queue에 넣기
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(box[i][j] == 1) 
                    q.offer(new Dot(i, j, 0));
            }
        }
 
        // bfs 시작
        while(!q.isEmpty()) {
            Dot dot = q.poll(); // Dot class dot 객체 생성 -> q.poll()로 맨 처음부터 익어있던 토마토 정보를 넣음
            day = dot.day;
 
            for(int i = 0; i < 4; i++) {
                int nx = dot.x + dirs[i][0];
                int ny = dot.y + dirs[i][1];
 
                if(0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if(box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        q.add(new Dot(nx, ny, day + 1));
                    }
                }
            }
        }
 
        // 토마토가 다 익었는지 확인
        if(checkTomato())
            System.out.println(day);
        else
            System.out.println(-1);
    }    
 
    // box 배열에 0이 남아있다면 false, 아니면 true
    static boolean checkTomato() {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(box[i][j] == 0)
                    return false;
            }
        } 
        return true;
    }
}
