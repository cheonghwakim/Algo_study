// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        int answer = 0;
        // write your code in Java SE 8
        Stack<Integer> st = new Stack<>();
        while(N != 0){
            st.add(N % 2);
            N /= 2;
        }

        while(!st.isEmpty()) {
            int cur = st.pop();

            if(cur == 1){
                int cnt = 0;
                while(!st.isEmpty() && st.peek() == 0){
                    st.pop();
                    cnt++;
                }
                if(!st.isEmpty() && st.peek() == 1)
                    answer = Math.max(cnt, answer);
            }
        }

        return answer;
    }
}
