package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractProcessingService;
import services.PicPayProcessingService;

public class MainProgram {

	public static void main(String[] args) throws ParseException  {
		
		
		//Since the main program is going to require input Date values, an SDF is needed
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Setting the decimal markers to dots for non-US pc's
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
		println("Enter the following Contract data:");
		println("");
		
		print("Contract Number: ");
		Integer number = sc.nextInt();
		
	
		print("Contract Date in the following format -> (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		
		print("Contract value: ");
		Double totalValue = sc.nextDouble();
		
		Contract contract = new Contract(number, date, totalValue);
		
		print("Enter the required number of installments: ");
		int n = sc.nextInt();
		
		ContractProcessingService cs = new ContractProcessingService(new PicPayProcessingService());
		
		cs.processContract(contract, n);
		
		
		println("");
		println("");
		println("List of Installments:");
		println("===============================================");
		for (Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		println("===============================================");
		
		}
		catch (InputMismatchException e) {
			e.getMessage();
			println("Stack Trace:");
			e.printStackTrace();
		}
		catch (ParseException e) {
			println("Invalid Date Format");
			println("Stack Trace:");
			e.printStackTrace();		
		}
		
		finally {

		sc.close();
		}
	}
	
	public static void println(String string) {
		System.out.println(string);
	}
	public static void print(String string) {
		System.out.print(string);
	}
}