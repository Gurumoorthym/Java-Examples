package dependencyInjection.main;

import dependencyInjection.consumer.MessageConsumer;
import dependencyInjection.injector.EmailMessageInjector;
import dependencyInjection.injector.MessageInjector;
import dependencyInjection.injector.SMSMessageInjector;

public class MainMessageSend {
	
	public static void main(String[] args) {
	
	String msg = "Hi this is a Test Message";
	String to = "Guru";
	
	MessageInjector mi = new EmailMessageInjector();
	MessageConsumer mc = mi.getConsumer();
	mc.processMessage(msg, to);
	
	MessageInjector smsmi = new SMSMessageInjector();
	MessageConsumer smsmc = smsmi.getConsumer();
	smsmc.processMessage(msg, to);
	
	}

}
