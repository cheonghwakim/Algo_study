import java.util.*;

public class Main {
	static String a,b;
	
	static int dp[][];
	
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		a=sc.nextLine();
		b=sc.nextLine();
		
		dp = new int[b.length()+1][a.length()+1]; // 각 문자열의 길이만큼 선언
        				// 주의해야 할 점은 무엇을 기준으로 무엇과 비교할지를 정한 후 순서에 맞게 선언해주어야 한다.
                        // 여기선 b를 기준으로 a와 비교하게 된다.
		
		for(int i=1;i<=b.length();i++) { // b를 기준으로
			
			for(int j=1;j<=a.length();j++) { // a와 비교
				
				if(b.charAt(i-1) != a.charAt(j-1)) { // 다를 경우
					
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]); //점화식
				}else { // 같을 경우
					dp[i][j] = dp[i-1][j-1]+1; // 점화식
				}
				
			}		
			
		}
		
		System.out.println(dp[b.length()][a.length()]); // 이곳 역시 선언과 똑같이 출력해주어야 런타임 에러가 나지 않는다.
		
  }
	
}
