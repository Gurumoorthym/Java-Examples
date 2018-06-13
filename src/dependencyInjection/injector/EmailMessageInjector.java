package dependencyInjection.injector;

import dependencyInjection.consumer.MessageConsumer;
import dependencyInjection.consumer.MessageSend;
import dependencyInjection.services.EmailMessageImpl;

public class EmailMessageInjector implements MessageInjector {

	@Override
	public MessageConsumer getConsumer() {
		
		return new MessageSend(new EmailMessageImpl());
	}

}
