// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int answer = Integer.MAX_VALUE;

        int right = 0;
        for(int i = 0; i < A.length; i++){
            right += A[i];
        }

        int left = 0;
        for(int i = 0; i < A.length - 1; i++){
            right -= A[i];
            left += A[i];
            int abs = Math.abs(right - left);
            answer = Math.min(answer, abs);
        }

        return answer;
    }
}

// https://app.codility.com/demo/results/trainingG2B29H-ZZ7/  범위 항상 잘 체크하기! 로직은 문제 없음
// https://app.codility.com/demo/results/training5GQ7NF-RMP/