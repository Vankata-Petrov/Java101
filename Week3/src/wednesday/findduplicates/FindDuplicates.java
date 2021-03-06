package wednesday.findduplicates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {
	@SafeVarargs
	public static <T> Set<T> findDuplicate(Set<T>... collection) {
		Set<T> uniqueSet = new HashSet<>(collection[0]);
		Set<T> backUp = new HashSet<>(uniqueSet);
		for (Set<T> set : collection) {
			uniqueSet.retainAll(set);
			if (uniqueSet.isEmpty()) {
				uniqueSet = backUp;
			}
		}
		return uniqueSet;
	}

	public static <T> void main(String[] args) {
		Set<Integer> a = new HashSet<Integer>(Arrays.asList(1, 2, 3, 7, 4, 5));
		Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 6));
		Set<Integer> c = new HashSet<Integer>(Arrays.asList(5, 6, 7, 8));
		Set<Integer> d = new HashSet<Integer>(Arrays.asList(6, 7, 8));
		Set<Integer> f = findDuplicate(a, b, c, d);
		if (f.size() > 1) {
			System.out.println("The most frequent elements are: " + f);
		} else {
			System.out.println("The most frequent element is: " + f);
		}
	}
}
