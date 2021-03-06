package friday.vattaxcalculator.model;

public enum CurrencyCourse {
	POUND(2.7048), EURO(1.95), AUD(1.28), LV(1);
	private double course;

	private CurrencyCourse(double course) {
		this.course = course;
	}

	public double getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return name() + " course " + course;
	}
}
