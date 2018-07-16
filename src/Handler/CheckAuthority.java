package Handler;

	class CheckAuthority {
		   public static void main(String[] args) {
		        Manager manager = new Manager();
		        Director director = new Director();
		        VicePresident vp = new VicePresident();
		        President president = new President();
		 
		        manager.setSuccessor(director);
		        director.setSuccessor(vp);
		        vp.setSuccessor(president);
		 
		        if (manager.processRequest(new PurchaseRequest("ExpensiveItem", 1000))) {
		            // OK
		        } else {
		            // can not authorise purchase.
		        }
		    }
		}
