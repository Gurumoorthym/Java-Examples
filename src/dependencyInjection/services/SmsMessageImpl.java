package dependencyInjection.services;

public class SmsMessageImpl implements MessageService{

	@Override
	public void sendMessage(String msg, String to) {
		System.out.printf("SMS Message : %s has been sent to %s \n", msg, to);
		
	}

}
