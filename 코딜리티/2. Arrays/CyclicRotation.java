// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        int size = A.length;
        int[] result = new int[size];
        if(size == 0)
            return result;
            
        // write your code in Java SE 8
        
        K %= A.length;

        for(int i = 0; i < size; i++){
            result[(i + K) % size] = A[i];
        }

        return result; 
    }
}