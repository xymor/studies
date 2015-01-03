// Number of disc interceptions

public int solution(int[] array) {
	int intersections = 0;
	for(int i = 1; i < array.length ; i++) {
		for(int j = 0; j < i; j++) {
			if((i - array[(int) i]) <= (j + array[(int) j])) {
				intersections++;
			}
		}
	}
	return intersections;
}
