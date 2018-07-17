package Handler;

public class Director extends Employee{

	@Override
	public boolean processRequest(PurchaseRequest purchaseRequest) {
		if (purchaseRequest.getQuantity() <= 500)//check for authorization
        {
			System.out.println("Ordered from Director");
			return true;
        }
        else
        {
        	System.out.println("Trying to process the purchase through: " +getSuccessor());
        	return getSuccessor().processRequest(purchaseRequest);
        }
		
	}


	
}
