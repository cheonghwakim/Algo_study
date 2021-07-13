// you can also use imports, for example:
import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8

        int[] answer = new int[N];
        int tmp = 0, max = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] <= N) {
                answer[A[i] - 1] = Math.max(answer[A[i] - 1], max) + 1;
                tmp = Math.max(tmp, answer[A[i] - 1]);
            
            } else if (A[i] == N + 1) {
                max = tmp;
            }
        }

        for(int i = 0; i < answer.length; i++){
            if(answer[i] < max)
                answer[i] = max;
        }
        return answer;
    }
}

// 1차: https://app.codility.com/demo/results/trainingSMYN6U-T7G/ 효율성 통과 못함
// 2차: https://app.codility.com/demo/results/trainingBBVYWU-QND/ 효율성 주의!