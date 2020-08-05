package model.services;

public interface Payments {
	
	double paymentFee(double amount);
	
	double interest(double amount, Integer months);

}
