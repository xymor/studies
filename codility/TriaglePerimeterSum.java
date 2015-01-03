

//Find the perimeter of a triangle, if the given array of integers has a triangle.
public int solution(int[] input) {
	int[] array = input.clone();
	int sum = -1;
	
	Arrays.sort(b); // This is magic
	for(int i = 0; i < b.length -2 ; i++){
	    int localSum = 0;
	    int first = b[i];
	    int second = b[i+1];
	    int third = b[i+2];
	    if(first + second > third){
		    localSum = number + second + third;
    		if(localSum > sum){
    		    sum = localSum;
    		}
	    }
	}
	return sum;
}
