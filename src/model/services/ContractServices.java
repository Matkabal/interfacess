package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installments;

public class ContractServices {
	
	private Payments payments;
	
	public ContractServices(){
		
	}

	public ContractServices(Payments payments) {
		super();
		this.payments = payments;
	}

	public void ProcessContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue()/months;
		
		for (int i = 1; i<=months;i++) {
			
			Date date = addMonths(contract.getDate(), i);
			double updateQuota = basicQuota + payments.interest(basicQuota, i);
			double fullQuota= updateQuota + payments.paymentFee(updateQuota);
			contract.addInstallments(new Installments(date, fullQuota));
			
		}
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	

}
