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
