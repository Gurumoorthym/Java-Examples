package Handler;

public abstract class Employee implements Chain{
	
	private Employee employee;
	
	public void setSuccessor(Employee employee) {
		this.employee = employee;
		
	}
	
	public Employee getSuccessor() {
		return this.employee;
	}

	public abstract boolean processRequest(PurchaseRequest purchaseRequest);
}
