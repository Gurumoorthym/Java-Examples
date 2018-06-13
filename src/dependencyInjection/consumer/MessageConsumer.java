package dependencyInjection.consumer;

public interface MessageConsumer {
	void processMessage(String msg, String to);
}
