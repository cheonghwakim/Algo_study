package jungol.Beginner_Coder.도형만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1719_별삼각형2 {
	static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
         
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
         
        if(n < 0 || n % 2 == 0 || n > 100 || m < 0 || m > 4) {
            System.out.println("INPUT ERROR!");
            return;
        }
         
        if(m == 1) {
            for (int i = 1; i <= n; i++) {
                if(i <= n / 2 + 1) {
                    for (int j = 1; j <= i; j++) {
                        sb.append("*");
                    }
                } else {
                    for (int j = 1; j <= n - i + 1; j++) {
                        sb.append("*");
                    }
                }
                sb.append("\n");
                     
            }
        } else if (m == 2) {
            for (int i = 1; i <= n; i++) {
                if(i <= n / 2 + 1) {
                    for (int j = 1; j <= n / 2 + 1; j++) {
                        if(j <= n / 2 + 1 - i) sb.append(" ");
                        else sb.append("*");
                    }
                } else {
                    for (int j = 1; j <= n / 2 + 1; j++) {
                        if(j <= i - n / 2 - 1) sb.append(" ");
                        else sb.append("*");
                    }
                }
                sb.append("\n");
            }
        } else if(m == 3) {
             for (int i = 1; i <= n; i++) {
                if(i <= n / 2) {
                    for (int j = 1; j < n - i + 2; j++) {
                        if(j < i) sb.append(" ");
                        else sb.append("*");
                    }
                } else {
                    for (int j = 1; j <= i; j++) {
                        if(j <= n - i) sb.append(" ");
                        else sb.append("*");
                    }
                }
                sb.append("\n");
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if(i <= n / 2 + 1) {
                    for (int j = 1; j <= n / 2 + 1; j++) {
                        if(j < i) sb.append(" ");
                        else sb.append("*");
                    }
                } else {
                    for (int j = 1; j <= i; j++) {
                        if(j <= n/ 2) sb.append(" ");
                        else sb.append("*");
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
     
    }

}
