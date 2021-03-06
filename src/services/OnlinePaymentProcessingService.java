package services;

public interface OnlinePaymentProcessingService {

	/*Standard methods for the online payment service contract
	 (Interface intermediation was preferred over common inter-class 
	 dependency composition in order to obtain a  significant weaker coupling 
	 between Contract Processing Service and (X) Specific Processing Service 
	 */
	
	double fee(double amount);
	double interest(double amount, int months);
	
	
}