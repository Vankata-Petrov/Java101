package com.boyko.vat.test;

import com.boyko.vat.database.CountryDatabase;
import com.boyko.vat.exceptions.CountryNotFoundException;
import com.boyko.vat.models.Country;

public class VatCalculator {
	private CountryDatabase db;

	public VatCalculator(CountryDatabase db) {
		this.db = db;
	}

	public double calculateTax(double netPrice, int countryCode)
			throws CountryNotFoundException {
		try {
			Country country = db.getCountry(countryCode);
			double vatRate = country.getVat();
			return Math.round(netPrice * (1 + (vatRate / 100)));

		} catch (Exception e) {
			throw new CountryNotFoundException("Country not found!");
		}
	}

	public double calculateTax(double price) throws CountryNotFoundException {
		try {
			return calculateTax(price, db.getDefaultCountry().getCountryCode());
		} catch (Exception e) {
			throw new CountryNotFoundException(
					"VAT calculator isn't support default country");
		}
	}
}