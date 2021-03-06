package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private Date date;
	private Integer number;
	private Double totalValue;
	
	/*Since the contract can have multiple installments,
	 it is responsible for instancing a list within itself
	*/
	List<Installment> installments;

	
	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
		//Direct list instantiation in the constructor
		installments = new ArrayList <Installment> ();
	}
	
	//Standard empty constructor just in case it is required for entities
	
	public Contract () {
	}
	
	public Date getDate() {
		return date;
	}

	
	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumber() {
		return number;
	}

	
	public void setNumber(Integer number) {
		this.number = number;
	}
	

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}	
}