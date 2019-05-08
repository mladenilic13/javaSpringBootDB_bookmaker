package kladionicaii.kladionica.pojoClassesRates;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class OuterClass {

	private String base;
	
	private InnerClass rates;

	private String date;
	
	public OuterClass() {
	}

	public OuterClass(String base, InnerClass rates, String date) {
		this.base = base;
		this.rates = rates;
		this.date = date;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public InnerClass getRates() {
		return rates;
	}

	public void setRates(InnerClass rates) {
		this.rates = rates;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "OuterClass [base=" + base + ", rates=" + rates + ", date=" + date + "]";
	}
	
}
