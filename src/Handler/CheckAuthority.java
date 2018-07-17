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
		        //Positive test case
		        if (manager.processRequest(new PurchaseRequest("ExpensiveItem", 1000))) {
		            System.out.println("Purchase Authorized");
		        } else {
		            System.out.println("Cannot Authorise purchase");
		        }
		        
		        //Negative test case
		        if (manager.processRequest(new PurchaseRequest("VERY ExpensiveItem", 10000))) {
		            System.out.println("Purchase Authorized");
		        } else {
		            System.out.println("Cannot Authorise purchase");
		        }
		    }
		}
