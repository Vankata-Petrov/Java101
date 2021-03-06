package wednesday.reversecollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReverseGenericCollection {

	static <T> void reverse(Collection<T> list) {
		// doesn't work for set
		Stack<T> stack = new Stack<>();
		for (T t : list) {
			stack.push(t);
		}
		Iterator<T> it = stack.iterator();
		list.clear();

		while (it.hasNext()) {
			list.add(stack.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> ll = new LinkedList<>();
		// Set<Integer> map = new HashSet<>();
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			l.add(i);
			ll.add(i);
			// map.add(i);
			stack.push(i);
		}
		reverse(ll);
		System.out.println("Reverse LinkedList ==> " + ll);
		reverse(stack);
		System.out.println("Reverse Stack ==> " + stack);
		reverse(l);
		System.out.println("Reverse List ==> " + l);
	}
}
