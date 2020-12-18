package jungol.Beginner_Coder.수학2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO1009_각자리수의역과합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int num = 1;
        int[] reverseNum;
        while(true) {
            num = Integer.parseInt(br.readLine());
            if(num == 0) break;
             
            reverseNum = new int[(int)(Math.log10(num)+1)];
             
            int sum = 0;
            for (int i = 0; i < reverseNum.length; i++) {
                reverseNum[i] = num % 10;
                sum += reverseNum[i];
                num /= 10;
            }
             
            String tmp = "";
            for (int i = 0; i < reverseNum.length; i++) {
                tmp += reverseNum[i];
            }
            int answer = Integer.parseInt(tmp);
             
            sb.append(answer).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
	}

}
