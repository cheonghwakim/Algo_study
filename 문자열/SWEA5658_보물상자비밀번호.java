package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class SWEA5658_보물상자비밀번호 {
	static int T, N, K, ans, size;
	static String[] numlist;
	static HashSet<Integer> hs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder string = new StringBuilder();
		
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T ; tc++) {
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            numlist = new String[N];
            
            ans = 0;
            size = N / 4;
            hs = new HashSet<>();
            String str = br.readLine();
            for (int i = 0; i <N ; i++) {
            	numlist[i] = String.valueOf(str.charAt(i));
            }
 
            for (int i = 0; i < size ; i++) {
                slideRight(i);
                HtD();
            }
 
            List<Integer> ls = new LinkedList<>(hs);
 
            Collections.sort(ls, Collections.reverseOrder());
 
            string.append("#").append(tc).append(" ").append(ls.get(K - 1)).append("\n");
        }
        System.out.println(string);
    }
 
    static void HtD(){
    	for(int i = 0 ; i < N; i += N / 4) {
			String hex = "";

			for(int j = i ; j < i + N / 4 ; ++j) {
				hex += numlist[j];
			}
			
			int dec = Integer.parseInt(hex, 16);
			hs.add(dec);
		}
    }
 
    static void slideRight(int c){
        if(c == 0) return;
        String ta = numlist[N - 1];
        
        for (int i = N - 1; i > 0; --i) {
        	numlist[i] = numlist[i - 1];
        }
        numlist[0] = ta;
    }


}
