package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	
	//SDF implemented in a static method in order not to be re-implemented in case other other Installment object is created
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	private Double amount;
	private Date duePaymentDate;
	
	//Standard empty constructor just in case it is required for entities
	
	public Installment() {
		
	}

	//Full constructor
	public Installment(Date duePaymentDate, Double amount) {
		
		this.duePaymentDate = duePaymentDate;
		this.amount = amount;
		
	}

	//Getters and Setters
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Date getDueDate() {
		return duePaymentDate;
	}

	public void setDueDate(Date dueDate) {
		this.duePaymentDate = dueDate;
	}

	//Formated toString override 
	@Override
	public String toString() {
		return sdf.format(duePaymentDate) + " - " + String.format("%.2f", amount);
	}
}