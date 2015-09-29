// Tape equilibrium
public int equilibrium(int[] array) {
	Set<Integer> list = new java.util.HashSet<Integer>();
	int position = 0;
	int skip = 0;
	for(int el : array) {
		if(list.contains(el)) {
			skip++;
			continue;
		} else {
			position += skip;
			skip = 0;
			list.add(el);
		}
	}
	return list.size() - 1 + position;
}

V2

import java.util.stream.*;

class Solution {
    public int solution(int[] A ){
          return minDiff(A);
    }
    public static int minDiff(int[] a) {
        int leftSum=0, rightSum=0;
        leftSum = IntStream.of(a).sum();
        
        int minDiff = Integer.MAX_VALUE;
        for(int p = a.length -1; p >= 0; p--){
            rightSum += a[p];
            leftSum -= a[p];
            
            int diff = Math.abs(leftSum - rightSum);
            if(diff == 0){
                return 0;
            } else if(diff < minDiff){
                minDiff = diff;
            }
        }
        return minDiff;
    }
}


