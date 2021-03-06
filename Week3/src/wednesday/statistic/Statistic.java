package wednesday.statistic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Statistic implements StatisticInterface, Iterable<Integer> {

	private List<Integer> numbers;
	private int size;

	public Statistic() {
		numbers = new ArrayList<Integer>();
	}

	public void add(int n) {
		numbers.add(n);
		size = numbers.size();
	}

	@Override
	public int getMean() {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum / size;
	}

	@Override
	public int getMedian() {
		Collections.sort(numbers);
		return size % 2 != 0 ? numbers.get((size + 1) / 2) : numbers
				.get(size / 2);
	}

	@Override
	public int getMode() {
		Collections.sort(numbers);
		int max = 0;
		int mostFrequentNumber = 0;
		for (int i = 0; i < size - 1; i++) {
			int currentNum = numbers.get(i);
			int nextNum = numbers.get(i + 1);
			int tempMax = 0;
			while (currentNum == nextNum) {
				currentNum = numbers.get(i);
				nextNum = numbers.get(i + 1);
				tempMax++;
				i++;
			}
			if (tempMax > max) {
				max = tempMax;
				mostFrequentNumber = numbers.get(i - 1);
			}
		}
		return mostFrequentNumber;
	}

	@Override
	public int getRange() {
		return Collections.max(numbers) - Collections.min(numbers);
	}

	@Override
	public Iterator<Integer> iterator() {
		return this.numbers.iterator();
	}
}
