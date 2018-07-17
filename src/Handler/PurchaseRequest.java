package Handler;

public class PurchaseRequest {
	private final String item;
	private final int quantity;
	
	public PurchaseRequest(String item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

}
