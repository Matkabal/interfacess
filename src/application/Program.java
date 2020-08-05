package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installments;
import model.services.ContractServices;
import model.services.Paypalpayments;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double amount = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int installment = sc.nextInt();
		
		Contract contract = new Contract(number, date, amount);
		
		ContractServices contractService = new ContractServices(new Paypalpayments());
		
		contractService.ProcessContract(contract, installment);
		
		
		System.out.println("Installments");
		
		for(Installments x : contract.getList()) {
			System.out.println(x);
			
		}
		
		
		
		
		
		
		
	}

}
