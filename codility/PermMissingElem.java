// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int found = 0;
        for(int i = 0; i <= A.length; i++){
            int diff = A[i+1] - A[i];
            if(diff > 1){
                found = A[i] +1;
                break;
            }
        }
        return found;
    }
}