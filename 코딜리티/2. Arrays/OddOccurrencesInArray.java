// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int j = 0; j < A.length; j++){
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
        }

        for(int i = 0; i < A.length; i++){
            if (map.get(A[i]) % 2 == 1)
                return A[i];
        }
        return 999999;
    }
}


// 1차: https://app.codility.com/demo/results/trainingGTKSA2-FVA/ 효율성 50
// 2차: https://app.codility.com/demo/results/trainingP5EFTC-983/ 