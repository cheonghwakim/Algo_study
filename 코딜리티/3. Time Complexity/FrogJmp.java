// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        if(X == Y)
            return 0;

        int cnt = (Y - X) / D;
        if((Y - X) % D != 0)
            cnt += 1;
        
        return cnt;
    }
}

// https://app.codility.com/demo/results/training7P7RXA-GS5/