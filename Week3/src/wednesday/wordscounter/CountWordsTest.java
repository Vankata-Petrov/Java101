package wednesday.wordscounter;

import java.util.Map;

public class CountWordsTest {

	public static void main(String[] args) {
		Map<String, Integer> result = TextUtil
				.createWordHistogram("Ninjas are all over the place! We are all going to die!");
		System.out.println(TextUtil.printHistogram(result));
	}
}
