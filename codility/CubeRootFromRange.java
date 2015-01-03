
//Find the number of perfect cube roots in a integer range
public int solution(int start, int end) {
	int acc = 0;
	for(int i = start; i < end ; i++){
		double root = Math.cbrt(i);
		if((i % root) == 0){
			acc = acc + 1;
		}
	}
	return acc;
}
