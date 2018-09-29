import java.util.Arrays;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] array) {
        //int[] array = {100, 250, 1000, 3000};
        int[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);
        if(array.length < 2) return 0;
        int total = sorted[0] + sorted[1];
        if(array.length == 2) return total;
        for(int i = 2; i < sorted.length; i++){
            total = sorted[i] + (total*2);
        }
        return total;
    }
}
