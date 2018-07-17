package Handler;

public class VicePresident extends Employee{

	@Override
	public boolean processRequest(PurchaseRequest purchaseRequest) {
		if (purchaseRequest.getQuantity() <= 750 )//check for authorization
        {
			System.out.println("Ordered from VicePresident");
			return true;
        }
        else
        {
        	System.out.println("Trying to process the purchase through: " +getSuccessor());
        	return getSuccessor().processRequest(purchaseRequest);
        }
		
	}

	
}
