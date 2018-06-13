package dependencyInjection.injector;

import dependencyInjection.consumer.MessageConsumer;

public interface MessageInjector {
	public MessageConsumer getConsumer();
}
