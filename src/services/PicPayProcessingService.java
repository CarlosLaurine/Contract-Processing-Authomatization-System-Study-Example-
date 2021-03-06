package services;

public class PicPayProcessingService implements OnlinePaymentProcessingService {

	//arguments defined as static since the fee and interest are fix
	
	private static final double FEE = 0.02;
	
	private static final double MONTHLY_INTEREST = 0.01;
	
	
	//Overrides
	
	@Override
	public double fee(double amount) {
		return amount * FEE;
	}

	@Override
	public double interest(double amount, int months) {
		return amount * months * MONTHLY_INTEREST;
	}
}