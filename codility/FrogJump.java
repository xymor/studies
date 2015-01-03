//Frog Jump

public int arrayJmp(int[] array) {
	int jumps = 0;
	int size = array.length;
	int position = 0;
	java.util.Set<Integer> visited = new java.util.HashSet<Integer>();
	visited.add(position);
	while(position < size) {
		position = position + A[(int) position];
		if(visited.contains(position)) {
			return -1;
		}
		visited.add(position);
		jumps++;
	}
	return jumps;
}
