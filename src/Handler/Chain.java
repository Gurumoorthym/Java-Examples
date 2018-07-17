package Handler;

public interface Chain {
	    public abstract void setSuccessor(Employee employee);
	    public abstract boolean processRequest(PurchaseRequest purchaseRequest);
	}
