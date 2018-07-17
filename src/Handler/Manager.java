package Handler;

public class Manager extends Employee{

	public boolean processRequest(PurchaseRequest purchaseRequest) {
		if (purchaseRequest.getQuantity() <= 250)//check for authorization
        {
			System.out.println("Ordered from Manager");
			return true;
        }
        else
        {
        	System.out.println("Trying to process the purchase through: " +getSuccessor());
        	return getSuccessor().processRequest(purchaseRequest);
        }
		
	}
	

}
