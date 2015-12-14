package friday.vattaxcalculator;

import friday.vattaxcalculator.enums.Country;

public class CurrencyConverter {
	public static double convert(double sum, Country to) {
		return sum * to.getCourse();
	}

	public static void main(String[] args) {
		System.out.println(CurrencyConverter.convert(100, Country.ENGLAND));
	}
}