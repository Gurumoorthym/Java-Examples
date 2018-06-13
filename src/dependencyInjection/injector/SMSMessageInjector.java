package dependencyInjection.injector;

import dependencyInjection.consumer.MessageConsumer;
import dependencyInjection.consumer.MessageSend;
import dependencyInjection.services.SmsMessageImpl;

public class SMSMessageInjector implements MessageInjector {

	@Override
	public MessageConsumer getConsumer() {
		
		return new MessageSend(new SmsMessageImpl());
	}

}
