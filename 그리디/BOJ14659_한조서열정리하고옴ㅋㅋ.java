package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14659_한조서열정리하고옴ㅋㅋ {
   static int N, num, cnt, max, answer;
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      max = Integer.parseInt(st.nextToken());
      for (int i = 1; i < N; i++) {
    	  num = Integer.parseInt(st.nextToken());
    	  
    	  max = Math.max(num, max);
         
    	  if(max > num) cnt++;
    	  else {
    		  max = num;
    		  cnt = 0;
    	  }
    	  answer = Math.max(cnt, answer);
      }
      
      System.out.println(answer);
   }
}