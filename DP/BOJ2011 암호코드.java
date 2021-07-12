import java.util.*;
import java.math.*;
public class Main {
	
	static int dp[][];
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		
	    String code = sc.next();
	    dp = new int [code.length()+1][2]; // 0: 끝자리가 한 자리, 1: 끝자리가 두 자리
	    
        //dp배열 초기화
	    dp[1][0] = 1; dp[1][1] =0;
	    dp[0][0] = 1; dp[0][1] =0;
        
        //0입력 시 종료
	    if(code.charAt(0)-'0' == 0) {
	    	System.out.println("0");
	    	return;
	    }
        
	    for(int i=2;i<=code.length();i++) {
	    	if(code.charAt(i-1)-'0'==0) { // 자기 자신이 0이고
	    		if(code.charAt(i-2)-'0' ==0) { // 앞 자리도 0이면
	    			System.out.println("0"); // 0출력 후 종료
	    			return;
	    		}else { // 그냥 자기 자신만 0인 경우 0으로 채워준다.
	    			dp[i][0] = 0;		
	    		}
	    	}else // 자기 자신이 0이 아닌 경우는 경우의 수가 존재한다.
	    		dp[i][0] = (dp[i-1][0]+dp[i-1][1]) % 1000000; // 이전 수의 0열 1열의 합
	    	
	    	
	    	if(code.charAt(i-2)-'0'==1) { // 자신의 앞 수가 1인 경우
	    		
	    		if(code.charAt(i-1)-'0'>=0 && code.charAt(i-1)-'0'<10) // 자신은 0~9가 가능하다.
	    			
	    			dp[i][1] = (dp[i-2][0]+dp[i-2][1]) % 1000000; // 이전 이전 수의 0열 1열의 합
	    	}
	    	else if(code.charAt(i-2)-'0'==2) { // 자신의 앞 수가 2인 경우
	    		if(code.charAt(i-1)-'0'>=0 && code.charAt(i-1)-'0'<=6) { // 0~6이 가능하다.
	    			dp[i][1] = (dp[i-2][0]+dp[i-2][1]) % 1000000; // 이전 이전 수의 0열 1열의 합
	    		}
	    	}
	    	else dp[i][1]=0; // 위의 범위에 속하지 않는 것은 경우의 수가 존재하지 않으므로 0
	    	
	    }
	    int sum =0;
	   
	    	
	    	for(int j=0;j<2;j++) { // 마지막 행의 0열 1열의 합이 모든 경우의 수가 된다.
	    	sum +=dp[code.length()][j];
	    	}
	    	
	    
	    System.out.println(sum % 1000000);
	   
	    
	}
	
}
