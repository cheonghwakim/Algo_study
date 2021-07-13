// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {

        Set<Integer> set = new HashSet<>();
        // write your code in Java SE 8
        for(int i = 0; i < A.length; i++){
            set.add(A[i]);
            if(set.size() == X)
                return i;
        }
        
        return -1;
    }
}

// https://app.codility.com/demo/results/trainingYMG2SB-66Z/ 문제 이해 잘못
// https://app.codility.com/demo/results/trainingGVJSEM-DQ4/ 인터넷 참고
// https://app.codility.com/demo/results/trainingHRTKHY-FS4/ 문제 이해를 잘못한 경우: 1~X까지는 낙엽이 깔리는 위치임! 낙엽이 떨어지는 시간이 아니라..