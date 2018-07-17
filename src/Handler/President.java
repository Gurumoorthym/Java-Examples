package Handler;

public class President extends Employee{

	@Override
	public boolean processRequest(PurchaseRequest purchaseRequest) {
		if (purchaseRequest.getQuantity() <= 1000)//check for authorization
        {
			System.out.println("Ordered from President");
			return true;
        }
        else
        {
        	return false;
        }
		
	}


}
