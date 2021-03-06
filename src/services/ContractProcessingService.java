package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractProcessingService {

	private OnlinePaymentProcessingService onlinePaymentService;
	
	public ContractProcessingService(OnlinePaymentProcessingService onlinePaymentService) {
		
		this.onlinePaymentService = onlinePaymentService;
		
	}
	
	//Method used to get the payment's quotas and process them with the specific online payment system's fee and monthly interest
	public void processContract(Contract contract, int months) {
		
		double basicQuota = contract.getTotalValue() / months;
		
		for (int i = 1; i <= months; i++) {
			
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			double fullQuota = updatedQuota + onlinePaymentService.fee(updatedQuota);
			Date dueDate = addMonths(contract.getDate(), i);		
			contract.getInstallments().add(new Installment(dueDate, fullQuota));
		}
		
	}
	
	
	
	//Method to add the installment total months by using Calendar
	private Date addMonths(Date date, int n) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);	
		return calendar.getTime();
		
	}
}