package model.services;

public class Paypalpayments implements Payments{
	
	private static final double FEE_POR = 0.02;
	private static final double MON_INTE = 0.01;
	

	@Override
	public double paymentFee(double amount) {
		return amount * FEE_POR;
	}

	@Override
	public double interest(double amount, Integer months) {

		return amount* MON_INTE*months;	}

}
