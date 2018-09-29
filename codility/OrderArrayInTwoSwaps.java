import java.util.Arrays;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public boolean solution(int[] A) {
        return check(A);
    }
    
    private boolean check(int[] array){
        int count = 0;
        int[] b = Arrays.copyOf(array, array.length);
        Arrays.sort(b);
        for(int i = 0; i < array.length; i++){
            if(b[i] != array[i]){
                count++;
            }
        }
        return count <= 2;
    }
    
}
