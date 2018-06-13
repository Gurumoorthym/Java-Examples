package dependencyInjection.services;

public class EmailMessageImpl implements MessageService{

	@Override
	public void sendMessage(String msg, String to) {
		System.out.printf("Email Message : %s has been sent to %s \n", msg, to);
		
	}

}
